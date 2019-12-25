<template>

  <div>
	<el-row gutter="0"><el-col :span="20" :offset="2">
		<el-container>
			<el-header height="150px" style=" background: rgb(64, 158, 255);">
				
				<el-row >
				
					
				<el-col :span="2" :offset="0">
					<el-image
							style="width: 100px; height: 100px"
							:src="url"
							:fit="contain"></el-image>
					
				</el-col>
		
				
				<el-col :span="4" :offset="0">
					<h1 style="font-size: 30px;"><font color="white"  size="10">企鹅物流</font></h1>
					</el-col>
				
				<el-col :span="2" :offset="16">
					<MainDropdown></MainDropdown>
				</el-col>
				
			
				</el-row>

				
			</el-header>
			<el-container>
				<el-aside width="400px">
					<navMenu @func="getMsg"></navMenu>
				</el-aside>
				<el-main>
					<el-container>
						<el-header>
						<el-divider></el-divider>
						</el-header>
						<el-main style="box-shadow: rgba(0, 0, 0, 0.12) 0px 2px 4px, rgba(0, 0, 0, 0.04) 0px 0px 6px;">
							
							<el-row :gutter="20">
							<el-col :span="20" :offset="2">
							<div v-if="type==='main'"><tabs></tabs> </div>
							<div v-if="type==='neworder'"><newOrder></newOrder></div>
							<div v-if="type==='searchOrder'"><searchOrder></searchOrder></div>
							<div v-if="type==='storagelist'"><storageList></storageList> </div>
							<div v-if="type==='orderlist'"><orderList></orderList> </div>
							</el-col>
							</el-row>
						</el-main>
					</el-container>
				</el-main>
			</el-container>
		</el-container>
	</el-col></el-row>
	</div>
  
</template>

<script>

import navMenu from './components/navMenu.vue'
import tabs from './components/tabs.vue'
import newOrder from './components/newOrder.vue'
import MainDropdown from './components/MainDropdown.vue'
import searchOrder from './components/searchOrder.vue'
import orderList from './components/orderList.vue'
import storageList from './components/storageList.vue'
export default {
  name: 'app',
  components: {
	tabs,
	navMenu,
	newOrder,
	MainDropdown,
	searchOrder,
	orderList,
	storageList
  },
  data() {
        return {
          type: 'main',
          url:'https://img.moegirl.org/common/1/10/%E4%BC%81%E9%B9%85%E7%89%A9%E6%B5%8102.png',
        }
	},

  methods:{
              getMsg(data){
                  this.type = data
        
              }
      }

}
</script>

<style>
.el-header, .el-footer {
    background-color:;
    color: #333;
    text-align: center;
    line-height: 60px;
  }
  .el-row {
      margin-bottom: 20px;
      &:last-child {
        margin-bottom: 0;
      }
	}

</style>



