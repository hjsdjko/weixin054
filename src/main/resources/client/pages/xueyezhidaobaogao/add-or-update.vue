<template>
<view class="content">
	<view :style='{"width":"100%","padding":"0 0 0 0","position":"relative","background":"#ffffff","height":"100%"}'>
		<form :style='{"width":"100%","padding":"24rpx 24rpx 24rpx 24rpx","background":"#ffffff","display":"block","height":"auto"}' class="app-update-pv">
			<view :style='{"padding":"4rpx 0 4rpx 0","margin":"0 0 24rpx 0","borderColor":"#cccccc","alignItems":"center","borderRadius":"8rpx 0 0 8rpx","borderWidth":"0px","background":"#e7fefc","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}' class="title">学号</view>
				<picker :style='{"width":"100%","flex":"1","height":"auto"}' @change="xuehaoChange" :value="xuehaoIndex"  :range="xuehaoOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#666666"}' class="uni-input">{{xuehaoOptions[xuehaoIndex]}}</view>
				</picker>
			</view>
			<view :style='{"padding":"4rpx 0 4rpx 0","margin":"0 0 24rpx 0","borderColor":"#cccccc","alignItems":"center","borderRadius":"8rpx 0 0 8rpx","borderWidth":"0px","background":"#e7fefc","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}' class="title">学生姓名</view>
				<input :style='{"border":"0px solid #eeeeee","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"8rpx","flex":"1","background":"#ffffff00","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' :disabled="ro.xueshengxingming" v-model="ruleForm.xueshengxingming" placeholder="学生姓名"></input>
			</view>
			<view :style='{"padding":"4rpx 0 4rpx 0","margin":"0 0 24rpx 0","borderColor":"#cccccc","alignItems":"center","borderRadius":"8rpx 0 0 8rpx","borderWidth":"0px","background":"#e7fefc","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class=" select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}' class="title">指导时间</view>
				<picker :style='{"width":"100%","flex":"1","height":"auto"}' mode="date" :value="ruleForm.zhidaoshijian" @change="zhidaoshijianChange">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#666666"}' class="uni-input">{{ruleForm.zhidaoshijian?ruleForm.zhidaoshijian:"请选择指导时间"}}</view>
				</picker>
			</view>
			<view :style='{"padding":"4rpx 0 4rpx 0","margin":"0 0 24rpx 0","borderColor":"#cccccc","alignItems":"center","borderRadius":"8rpx 0 0 8rpx","borderWidth":"0px","background":"#e7fefc","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="select">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}' class="title">导师工号</view>
				<picker :style='{"width":"100%","flex":"1","height":"auto"}' @change="daoshigonghaoChange" :value="daoshigonghaoIndex"  :range="daoshigonghaoOptions">
					<view :style='{"width":"100%","lineHeight":"80rpx","fontSize":"28rpx","color":"#666666"}' class="uni-input">{{daoshigonghaoOptions[daoshigonghaoIndex]}}</view>
				</picker>
			</view>
			<view :style='{"padding":"4rpx 0 4rpx 0","margin":"0 0 24rpx 0","borderColor":"#cccccc","alignItems":"center","borderRadius":"8rpx 0 0 8rpx","borderWidth":"0px","background":"#e7fefc","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}' class="title">导师姓名</view>
				<input :style='{"border":"0px solid #eeeeee","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"8rpx","flex":"1","background":"#ffffff00","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' :disabled="ro.daoshixingming" v-model="ruleForm.daoshixingming" placeholder="导师姓名"></input>
			</view>
			<view :style='{"padding":"4rpx 0 4rpx 0","margin":"0 0 24rpx 0","borderColor":"#cccccc","alignItems":"center","borderRadius":"8rpx 0 0 8rpx","borderWidth":"0px","background":"#e7fefc","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}' class="title">学业导师评价</view>
				<input :style='{"border":"0px solid #eeeeee","padding":"0px 24rpx 0px 24rpx","margin":"0 0 0 0","color":"#666666","borderRadius":"8rpx","flex":"1","background":"#ffffff00","fontSize":"28rpx","lineHeight":"80rpx","height":"80rpx"}' :disabled="ro.xueyedaoshipingjia" v-model="ruleForm.xueyedaoshipingjia" placeholder="学业导师评价"></input>
			</view>
			
			<!-- 否 -->
 

			<view :style='{"padding":"4rpx 0 4rpx 0","margin":"0 0 24rpx 0","borderColor":"#cccccc","alignItems":"center","borderRadius":"8rpx 0 0 8rpx","borderWidth":"0px","background":"#e7fefc","display":"flex","width":"100%","borderStyle":"solid","height":"auto"}' class="">
				<view :style='{"width":"160rpx","padding":"0 20rpx 0 0","lineHeight":"80rpx","fontSize":"28rpx","color":"#333333","textAlign":"right"}' class="title">指导学生情况</view>
				<textarea :style='{"border":"0px solid #eeeeee","padding":"24rpx 24rpx 24rpx 24rpx","margin":"0 0 0 0","color":"#000000","borderRadius":"8rpx","flex":"1","background":"none","fontSize":"28rpx","height":"240rpx"}' v-model="ruleForm.zhidaoxueshengqingkuang" placeholder="指导学生情况"></textarea>
			</view>
			
			
			<view :style='{"width":"100%","justifyContent":"center","display":"flex","height":"auto"}' class="btn" >
				<button :style='{"border":"0px solid #eeeeee","padding":"0 0 0 0","boxShadow":"0px 12rpx 12rpx -12rpx #228a7f","margin":"0 4% 0 0","color":"#ffffff","borderRadius":"40rpx 0 0 0","background":"#75ebde","width":"30%","lineHeight":"80rpx","fontSize":"28rpx","height":"80rpx"}' @tap="onSubmitTap" class="bg-red">提交</button>
			</view>
		</form>

	</view>
</view>
</template>

<script>
	import wPicker from "@/components/w-picker/w-picker.vue";
    import xiaEditor from '@/components/xia-editor/xia-editor';
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
				cross:'',
				ruleForm: {
				xuehao: '',
				xueshengxingming: '',
				zhidaoshijian: '',
				zhidaoxueshengqingkuang: '',
				daoshigonghao: '',
				daoshixingming: '',
				xueyedaoshipingjia: '',
				},
				xuehaoOptions: [],
				xuehaoIndex: 0,
				daoshigonghaoOptions: [],
				daoshigonghaoIndex: 0,
				// 登录用户信息
				user: {},
                ro:{
                   xuehao : false,
                   xueshengxingming : false,
                   zhidaoshijian : false,
                   zhidaoxueshengqingkuang : false,
                   daoshigonghao : false,
                   daoshixingming : false,
                   xueyedaoshipingjia : false,
                },
			}
		},
		components: {
			wPicker,
            xiaEditor,
            multipleSelect
		},
		watch:{
		},
		async onLoad(options) {
			let table = uni.getStorageSync("nowTable");
			// 获取用户信息
			let res = await this.$api.session(table);
			this.user = res.data;
			
			// ss读取


			// 下2
			res = await this.$api.option(`xuesheng`,`xuehao`,{});
			this.xuehaoOptions = res.data;
			// 下2
			res = await this.$api.option(`xueyedaoshi`,`daoshigonghao`,{});
			this.daoshigonghaoOptions = res.data;

			// 如果有登录，获取登录后保存的userid
			this.ruleForm.userid = uni.getStorageSync("userid")
			if (options.refid) {
				// 如果上一级页面传递了refid，获取改refid数据信息
				this.ruleForm.refid = options.refid;
				this.ruleForm.nickname = uni.getStorageSync("nickname");
			}
			// 如果是更新操作
			if (options.id) {
				this.ruleForm.id = options.id;
				// 获取信息
				res = await this.$api.info(`xueyezhidaobaogao`, this.ruleForm.id);
				this.ruleForm = res.data;
			}
			// 跨表
			this.cross = options.cross;
			if(options.cross){
				var obj = uni.getStorageSync('crossObj');
				for (var o in obj){
					if(o=='xuehao'){
					this.ruleForm.xuehao = obj[o];
					this.ro.xuehao = true;
					continue;
					}
					if(o=='xueshengxingming'){
					this.ruleForm.xueshengxingming = obj[o];
					this.ro.xueshengxingming = true;
					continue;
					}
					if(o=='zhidaoshijian'){
					this.ruleForm.zhidaoshijian = obj[o];
					this.ro.zhidaoshijian = true;
					continue;
					}
					if(o=='zhidaoxueshengqingkuang'){
					this.ruleForm.zhidaoxueshengqingkuang = obj[o];
					this.ro.zhidaoxueshengqingkuang = true;
					continue;
					}
					if(o=='daoshigonghao'){
					this.ruleForm.daoshigonghao = obj[o];
					this.ro.daoshigonghao = true;
					continue;
					}
					if(o=='daoshixingming'){
					this.ruleForm.daoshixingming = obj[o];
					this.ro.daoshixingming = true;
					continue;
					}
					if(o=='xueyedaoshipingjia'){
					this.ruleForm.xueyedaoshipingjia = obj[o];
					this.ro.xueyedaoshipingjia = true;
					continue;
					}
				}
			}
			this.styleChange()
            this.$forceUpdate()
		},
		methods: {
			styleChange() {
				this.$nextTick(()=>{
					document.querySelectorAll('.radioText').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"color":"#666666"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.radioTextActive').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"color":"#00babd"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.checkText').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"color":"#666666"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.checkTextActive').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"color":"#00babd"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.uni-radio-input').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"border":"2rpx solid #999999","borderRadius":"100%","background":"#ffffff"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.uni-radio-input-checked').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"border":"2rpx solid #00babd","borderRadius":"100%","background":"#19d2d5"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.uni-checkbox-input').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"border":"2rpx solid #999999","borderRadius":"100%","background":"#ffffff"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.uni-checkbox-input-checked').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"border":"2rpx solid #00babd","color":"#ffffff","borderRadius":"100%","background":"#19d2d5"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
				})
			},
			// 下二随
			async xuehaoChange (e) {
				this.xuehaoIndex = e.target.value
				this.ruleForm.xuehao = this.xuehaoOptions[this.xuehaoIndex]
				let res = await this.$api.follow(`xuesheng`, `xuehao`,{
					columnValue: this.ruleForm.xuehao
				});
				if(res.data.xueshengxingming){
					this.ruleForm.xueshengxingming = res.data.xueshengxingming
				}
				if(res.data.daoshixingming){
					this.ruleForm.daoshixingming = res.data.daoshixingming
				}
			},
			// 下二随
			async daoshigonghaoChange (e) {
				this.daoshigonghaoIndex = e.target.value
				this.ruleForm.daoshigonghao = this.daoshigonghaoOptions[this.daoshigonghaoIndex]
				let res = await this.$api.follow(`xueyedaoshi`, `daoshigonghao`,{
					columnValue: this.ruleForm.daoshigonghao
				});
				if(res.data.xueshengxingming){
					this.ruleForm.xueshengxingming = res.data.xueshengxingming
				}
				if(res.data.daoshixingming){
					this.ruleForm.daoshixingming = res.data.daoshixingming
				}
			},

			// 多级联动参数

			zhidaoshijianChange(e) {
				this.ruleForm.zhidaoshijian = e.target.value;
				this.$forceUpdate();
			},



			getUUID () {
				return new Date().getTime();
			},
			async onSubmitTap() {















//跨表计算判断
				var obj;
				//更新跨表属性
			       var crossuserid;
			       var crossrefid;
			       var crossoptnum;
				if(this.cross){
                    uni.setStorageSync('crossCleanType',true);
					var statusColumnName = uni.getStorageSync('statusColumnName');
					var statusColumnValue = uni.getStorageSync('statusColumnValue');
					if(statusColumnName!='') {
                        if(!obj) {
						    obj = uni.getStorageSync('crossObj');
                        }
						if(!statusColumnName.startsWith("[")) {
							for (var o in obj){
								if(o==statusColumnName){
									obj[o] = statusColumnValue;
								}

							}
							var table = uni.getStorageSync('crossTable');
							await this.$api.update(`${table}`, obj);
						} else {
						       crossuserid=Number(uni.getStorageSync('userid'));
						       crossrefid=obj['id'];
						       crossoptnum=uni.getStorageSync('statusColumnName');
						       crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
						}
					}
				}
				if(crossrefid && crossuserid) {
					this.ruleForm.crossuserid=crossuserid;
					this.ruleForm.crossrefid=crossrefid;
					let params = {
						page: 1,
						limit:10,
						crossuserid:crossuserid,
						crossrefid:crossrefid,
					}
					let res = await this.$api.list(`xueyezhidaobaogao`, params);
					if (res.data.total >= crossoptnum) {
						this.$utils.msg(uni.getStorageSync('tips'));
                        uni.removeStorageSync('crossCleanType');
						return false;
					} else {
                //跨表计算
						if(this.ruleForm.id){
							await this.$api.update(`xueyezhidaobaogao`, this.ruleForm);
						}else{
							await this.$api.add(`xueyezhidaobaogao`, this.ruleForm);
						}
						this.$utils.msgBack('提交成功');
					}
				} else {
                //跨表计算
					if(this.ruleForm.id){
						await this.$api.update(`xueyezhidaobaogao`, this.ruleForm);
					}else{
						await this.$api.add(`xueyezhidaobaogao`, this.ruleForm);
					}
					this.$utils.msgBack('提交成功');
				}
			},
			optionsChange(e) {
				this.index = e.target.value
			},
			bindDateChange(e) {
				this.date = e.target.value
			},
			getDate(type) {
				const date = new Date();
				let year = date.getFullYear();
				let month = date.getMonth() + 1;
				let day = date.getDate();
				if (type === 'start') {
					year = year - 60;
				} else if (type === 'end') {
					year = year + 2;
				}
				month = month > 9 ? month : '0' + month;;
				day = day > 9 ? day : '0' + day;
				return `${year}-${month}-${day}`;
			},
			toggleTab(str) {
				this.$refs[str].show();
			},
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
