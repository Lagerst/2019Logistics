<template>

<div>
	<el-col :span="10" >
<el-form ref="form" :model="form" label-width="80px" border-shadow:4px >
  <el-form-item label="货单号" style="width:400px;">
    <el-input v-model="form.num"></el-input>
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





