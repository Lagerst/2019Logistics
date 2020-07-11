 <template>
	<el-col :span="10" >
<el-form ref="form" :model="form" label-width="80px" border-shadow:4px >
  <el-form-item label="货单号" style="width:400px;">
    <el-input v-model="form.num"></el-input>
  </el-form-item>
  <el-form-item label="商品名" style="width:300px;">
    <el-input v-model="form.name"></el-input>
  </el-form-item>
  <el-form-item label="类型">
    <el-select v-model="form.type" placeholder="请选择类型">
      <el-option label="类型一" value="食品"></el-option>
      <el-option label="类型二" value="电子产品"></el-option>
    </el-select>
  </el-form-item>
  <el-form-item label="数量" style="width:300px;">
  <el-input v-model="form.quantity"></el-input>
  </el-form-item>
  <el-form-item label="发货时间">
    <el-col :span="11">
      <el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 100%;"></el-date-picker>
    </el-col>
    <el-col class="line" :span="2">-</el-col>
    <el-col :span="11">
      <el-time-picker placeholder="选择时间" v-model="form.date2" style="width: 100%;"></el-time-picker>
    </el-col>
  </el-form-item>
  <el-form-item label="发货仓库">
    <el-select v-model="form.storage" placeholder="请选择起始地">
      <el-option label="天津仓库" value="tianjing"></el-option>
      <el-option label="成都仓库" value="chengdu"></el-option>
    </el-select>
  </el-form-item>
<el-form-item label="收货地址">
    <el-select v-model="form.province" placeholder="请选择省份">
		<el-option label="河北" value="tianjing"></el-option>
		<el-option label="成都" value="chengdu"></el-option>
    </el-select>
	<el-select v-model="form.city" placeholder="请选择城市">
		<el-option label="唐山" value="tianjing"></el-option>
		<el-option label="成都" value="chengdu"></el-option>
	</el-select>
	<el-select v-model="form.district" placeholder="请选择区县">
		<el-option label="路北区" value="tianjing"></el-option>
		<el-option label="成华区" value="chengdu"></el-option>
	</el-select>
	<el-input v-model="form.address" placeholder="地址"></el-input>
	
  </el-form-item>
  
  <el-form-item label="备注">
    <el-input type="textarea" v-model="form.desc"></el-input>
  </el-form-item>
  <el-form-item>
    <el-button type="primary" @click="onSubmit">立即创建</el-button>
    <el-button>取消</el-button>
  </el-form-item>

</el-form>
  </el-col>

</template>
<script>
	const axios = require('axios');
  export default {
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
          quantity:'',
          
          desc: ''
        },
		result:false,
      }
    },
    methods: {
      onSubmit() {
        axios.post('http://localhost:8085/newOrder', this.form)
          .then((response)=> {
            this.result=response.data;
			if(this.result)
				this.$message({
				message: '提交成功',
				type: 'success'
				});
			else this.$message.error({message: '提交失败'});
          })
          .catch(function (error) {
            window.console.log(error);
          });
		
		
      }
    }
  }
</script>





