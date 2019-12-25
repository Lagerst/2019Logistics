<template>
	<div>
	<el-table
    :data="tableData"
    stripe
    style="width: 100%"
	@row-click="info">
    <el-table-column
      prop="num"
      label="货单号"
      width="150">
    </el-table-column>
    <el-table-column
      prop="name"
      label="商品名"
      width="150">
    </el-table-column>
	<el-table-column
		prop="storage"
		label="发出仓库"
		width="150">
	</el-table-column>
    <el-table-column
		prop="sendtime"
		label="发出时间"
		width="150">
    </el-table-column>
    <el-table-column
        prop="sendjudge"
        label="确认收货"
        width="150">
            <el-button @click.stop="open" type="text" size="small">确认收货</el-button>
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
      data() {
          return {
              tableData: [
              ],
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
      mounted: function () {
          this.getData();
      },
      methods: {
          getData() {
              axios.get('http://localhost:8085/orderlist')
                  .then((response) => {
                      window.console.log(response);
                      this.tableData = response.data;
                  })
                  .catch((error) => {
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
          open() {
              this.$alert('是否确定收货？', '确认收货', {
                  confirmButtonText: '确定',
                  callback: action => {
                      this.$message({
                          type: 'info',
                          message: `action: ${action}`
                      });
                  }
              });
          },
      }
  }
</script>


