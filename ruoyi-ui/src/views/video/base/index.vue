<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="所属视频组ID" prop="videoGroupId">
        <el-input
          v-model="queryParams.videoGroupId"
          placeholder="请输入所属视频组ID"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="视频标题" prop="videoTitle">
        <el-input
          v-model="queryParams.videoTitle"
          placeholder="请输入视频标题"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="视频分类ID" prop="typeId">
        <el-input
          v-model="queryParams.typeId"
          placeholder="请输入视频分类ID"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否推荐" prop="isTop">
        <el-input
          v-model="queryParams.isTop"
          placeholder="请输入是否推荐"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否热门" prop="isHot">
        <el-input
          v-model="queryParams.isHot"
          placeholder="请输入是否热门"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:base:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:base:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:base:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:base:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="baseList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="id" align="center" prop="id" />
      <el-table-column label="所属视频组" align="center" prop="videoGroupId" />
      <el-table-column label="视频标题" align="center" prop="videoTitle" />
      <el-table-column label="视频封面" align="center" prop="videoBanner" />
      <el-table-column label="视频资源" align="center" prop="videoSourceId" />
      <el-table-column label="视频分类" align="center" prop="typeId" />
      <el-table-column label="状态" align="center" prop="status" />
      <el-table-column label="是否推荐" align="center" prop="isTop" />
      <el-table-column label="是否热门" align="center" prop="isHot" />
      <el-table-column label="创建时间" align="center" prop="createDate" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.createDate, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:base:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:base:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改视频基础对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="所属视频组ID" prop="videoGroupId">
          <el-input v-model="form.videoGroupId" placeholder="请输入所属视频组ID" />
        </el-form-item>
        <el-form-item label="视频标题" prop="videoTitle">
          <el-input v-model="form.videoTitle" placeholder="请输入视频标题" />
        </el-form-item>
        <el-form-item label="视频简介" prop="videoInfomation">
          <el-input v-model="form.videoInfomation" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="视频封面" prop="videoBanner">
          <el-input v-model="form.videoBanner" placeholder="请输入视频封面" />
        </el-form-item>
        <el-form-item label="视频资源id" prop="videoSourceId">
          <el-input v-model="form.videoSourceId" placeholder="请输入视频资源id" />
        </el-form-item>
        <el-form-item label="视频分类ID" prop="typeId">
          <el-input v-model="form.typeId" placeholder="请输入视频分类ID" />
        </el-form-item>
        <el-form-item label="是否推荐" prop="isTop">
          <el-input v-model="form.isTop" placeholder="请输入是否推荐" />
        </el-form-item>
        <el-form-item label="是否热门" prop="isHot">
          <el-input v-model="form.isHot" placeholder="请输入是否热门" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" placeholder="请输入备注" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listBase, getBase, delBase, addBase, updateBase } from "@/api/video/base";

export default {
  name: "Base",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 视频基础表格数据
      baseList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        videoGroupId: null,
        videoTitle: null,
        videoInfomation: null,
        videoBanner: null,
        videoSourceId: null,
        typeId: null,
        status: null,
        isTop: null,
        isHot: null,
        createDate: null,
        updateDate: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询视频基础列表 */
    getList() {
      this.loading = true;
      listBase(this.queryParams).then(response => {
        this.baseList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        videoGroupId: null,
        videoTitle: null,
        videoInfomation: null,
        videoBanner: null,
        videoSourceId: null,
        typeId: null,
        status: 0,
        isTop: null,
        isHot: null,
        createDate: null,
        createBy: null,
        updateDate: null,
        updateBy: null,
        remark: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加视频";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getBase(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改视频";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateBase(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addBase(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除视频基础编号为"' + ids + '"的数据项？').then(function() {
        return delBase(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/base/export', {
        ...this.queryParams
      }, `base_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
