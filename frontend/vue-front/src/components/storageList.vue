<template>
	
	<div>
	<el-select v-model="value" placeholder="请选择">
		<el-option
			v-for="item in options"
			:key="item.value"
			:label="item.label"
			:value="item.value">
		</el-option>
		</el-select>
		<el-button type="primary" @click="getData">确认</el-button>
	<el-table
   :data="tableData"
  stripe
  style="width: 100%">
  <el-table-column
    prop="num"
    label="商品编号"
    width="180">
  </el-table-column>
  <el-table-column
    prop="name"
    label="商品名"
    width="180">
  </el-table-column>
  <el-table-column
	prop="type"
	label="类型"
	width="180">
  </el-table-column>
  <el-table-column
    prop="quantity"
    label="数量"
    width="180">
  </el-table-column>

	</el-table>
  </div>
</template>

<script>
	const axios = require('axios');
	export default {
		data() {
			return {
				options: [{
				value: 'storage1',
				label: '仓库1'
			}, {
				value: 'storage2',
				label: '仓库2'
			}, {
				value: 'storage3',
				label: '仓库3'
			}, ],
				value: '',
				tableData: []
			}
		},
		
		
		methods:{
			getData() {
			axios.post('http://localhost:8085/storagelist',{storage:this.value})
			.then( (response) => {
				window.console.log(response);
				this.tableData=response.data;
			})
			.catch( (error) => {
				window.console.log(error);
			});
		}
		}
	}
	
	
	
</script>

<style>
</style>
