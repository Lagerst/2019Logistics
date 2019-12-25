<template>

<div>
	<el-col :span="10" >
<el-form ref="form" :model="form" label-width="80px" border-shadow:4px >
  <el-form-item label="货单号" style="width:400px;">
    <el-input v-model="form.num"></el-input>
  </el-form-item>
  <el-form-item label="商品名" style="width:300px;">
    <el-input v-model="form.name"></el-input>
  </el-form-item>
  <el-form-item label="收件姓名" style="width:300px;">
    <el-input v-model="form.rename"></el-input>
  </el-form-item>
  <el-form-item label="类型">
    <el-select v-model="form.type" placeholder="请选择类型">
      <el-option label="类型一" value="食品"></el-option>
      <el-option label="类型二" value="电子产品"></el-option>
    </el-select>
  </el-form-item>
  <el-form-item label="日期范围">
    <el-col :span="11">
      <el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 100%;"></el-date-picker>
    </el-col>
    <el-col class="line" :span="2">-</el-col>
    <el-col :span="11">
       <el-date-picker type="date" placeholder="选择日期" v-model="form.date2" style="width: 100%;"></el-date-picker>
    </el-col>
  </el-form-item>
  <el-form-item label="发货仓库">
    <el-select v-model="form.storage" placeholder="请选择起始地">
      <el-option label="天津仓库" value="tianjing"></el-option>
      <el-option label="成都仓库" value="chengdu"></el-option>
    </el-select>
  </el-form-item>

  <el-form-item>
    <el-button type="primary" @click="onSubmit">立即查询</el-button>
    <el-button>取消</el-button>
  </el-form-item>
 <el-divider></el-divider>
</el-form>
 </el-col>


<el-table
    :data="tableData"
    stripe
    style="width: 100%"
    @row-click="info">
    <el-table-column
      prop="num"
      label="货单号"
      width="180">
    </el-table-column>
    <el-table-column
      prop="name"
      label="商品名"
      width="180">
    </el-table-column>
	<el-table-column
        prop="storage"
        label="发出仓库"
        width="180">
    </el-table-column>
    <el-table-column
		prop="sendtime"
		label="发出时间">
    </el-table-column>
  </el-table>
<el-dialog title="物流状态" :visible.sync="dialogVisible">
    <el-timeline>
        <el-timeline-item
                v-for="(activity, index) in activities"
                :key="index"
                :icon="activity.icon"
                :type="activity.type"
                :color="activity.color"
                :size="activity.size"
                :timestamp="activity.timestamp">
            {{activity.content}}
        </el-timeline-item>
    </el-timeline>
</el-dialog>
</div>

</template>
<script>

	const axios = require('axios');
  export default {
	components: {

	},
    data() {
      return {

        form: {
          num:'',
          name: '',
          type: '',
          storage:'',
          date1: '',
          date2: '',
          province:'',
          city:'',
          district:'',
          address:'',


          desc: '',
        },
		tableData: [{
		}],
          activities: [{
              content: '发货',
              timestamp: '2018-04-12 20:46',
              size: 'large',
              type: 'primary',
              icon: 'el-icon-more'
          }, {
              content: '中转',
              timestamp: '2018-04-03 20:46',
              color: '#0bbd87'
          }, {
              content: '中转',
              timestamp: '2018-04-03 20:46',
              size: 'large'
          }, {
              content: '收货',
              timestamp: '2018-04-03 20:46'
          }],
          dialogVisible: false
      }
    },
    methods: {
      onSubmit() {

        axios.post('http://localhost:8085/searchOrder', this.form)
          .then((response)  =>{
           window.console.log(response);
           this.tableData=response.data;
          })
          .catch(function (error) {
            window.console.log(error);
          });
      },
        info(row) {
            axios.post('http://localhost:8085/info', {num: row.num})
                .then((response) => {
                    window.console.log(response);
                    this.activities = response.data;
                })
                .catch((error) => {
                    window.console.log(error);
                });

            this.dialogVisible = true;
        },
    }
  }
</script>





