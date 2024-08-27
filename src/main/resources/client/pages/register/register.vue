<template>
<view class="content">
	<view class="box" :style='{"minHeight":"100vh","width":"100%","padding":"424rpx 44rpx 44rpx 44rpx","background":"url(http://codegen.caihongy.cn/20230815/be5343490bf4412389da1378210fd727.jpg) no-repeat center top / 100%","height":"100%"}'>
		<view :style='{"padding":"48rpx 48rpx 24rpx 48rpx","boxShadow":"0px 0px 12rpx #dddddd","borderRadius":"16rpx 100rpx","background":"#ffffff","display":"block","width":"100%","height":"auto"}'>
			<image :style='{"width":"160rpx","margin":"0","borderRadius":"100%","objectFit":"cover","display":"none","height":"160rpx"}' src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg" mode="aspectFill"></image>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#666666","borderRadius":"0px","background":"#ffffff","borderWidth":"0 0 2rpx 0","width":"100%","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.xuehao" type="text" class="uni-input" name="" placeholder="学号" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#666666","borderRadius":"0px","background":"#ffffff","borderWidth":"0 0 2rpx 0","width":"100%","fontSize":"28rpx","height":"88rpx"}' v-model="ruleForm.mima" type="password" class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#666666","borderRadius":"0px","background":"#ffffff","borderWidth":"0 0 2rpx 0","width":"100%","fontSize":"28rpx","height":"88rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#666666","borderRadius":"0px","background":"#ffffff","borderWidth":"0 0 2rpx 0","width":"100%","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.xueshengxingming" type="text" class="uni-input" name="" placeholder="学生姓名" />
			</view>
            <view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='xuesheng'" @tap="xueshengtouxiangTap" class="">
                <view>请上传头像</view>
                <image :style='{"width":"160rpx","borderRadius":"16rpx","objectFit":"contain","display":"block","height":"160rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"width":"160rpx","borderRadius":"16rpx","objectFit":"contain","display":"block","height":"160rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<picker :style='{"border":"2rpx solid #eeeeee","padding":"0 20rpx","margin":"0 0 24rpx 0","borderRadius":"0px","borderWidth":"0 0 2rpx 0","width":"100%","height":"auto"}' v-if="tableName=='xuesheng'"  @change="xueshengxingbieChange" :value="xueshengxingbieIndex" :range="xueshengxingbieOptions">
				<view :style='{"width":"100%","lineHeight":"88rpx","fontSize":"28rpx","color":"#666666"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
			</picker>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#666666","borderRadius":"0px","background":"#ffffff","borderWidth":"0 0 2rpx 0","width":"100%","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.zhuanye" type="text" class="uni-input" name="" placeholder="专业" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#666666","borderRadius":"0px","background":"#ffffff","borderWidth":"0 0 2rpx 0","width":"100%","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.banji" type="text" class="uni-input" name="" placeholder="班级" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='xuesheng'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#666666","borderRadius":"0px","background":"#ffffff","borderWidth":"0 0 2rpx 0","width":"100%","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.lianxifangshi" type="text" class="uni-input" name="" placeholder="联系方式" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='xueyedaoshi'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#666666","borderRadius":"0px","background":"#ffffff","borderWidth":"0 0 2rpx 0","width":"100%","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.daoshigonghao" type="text" class="uni-input" name="" placeholder="导师工号" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='xueyedaoshi'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#666666","borderRadius":"0px","background":"#ffffff","borderWidth":"0 0 2rpx 0","width":"100%","fontSize":"28rpx","height":"88rpx"}' v-model="ruleForm.mima" type="password" class="uni-input" name="" placeholder="密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='xueyedaoshi'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#666666","borderRadius":"0px","background":"#ffffff","borderWidth":"0 0 2rpx 0","width":"100%","fontSize":"28rpx","height":"88rpx"}' v-model="ruleForm.mima2" type="password" class="uni-input" name="" placeholder="确认密码" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='xueyedaoshi'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#666666","borderRadius":"0px","background":"#ffffff","borderWidth":"0 0 2rpx 0","width":"100%","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.daoshixingming" type="text" class="uni-input" name="" placeholder="导师姓名" />
			</view>
            <view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='xueyedaoshi'" @tap="xueyedaoshitouxiangTap" class="">
                <view>请上传头像</view>
                <image :style='{"width":"160rpx","borderRadius":"16rpx","objectFit":"contain","display":"block","height":"160rpx"}' v-if="ruleForm.touxiang" class="avator" :src="baseUrl+ruleForm.touxiang" mode=""></image>
                <image :style='{"width":"160rpx","borderRadius":"16rpx","objectFit":"contain","display":"block","height":"160rpx"}' v-else class="avator" src="../../static/gen/upload.png" mode=""></image>
            </view>
			<picker :style='{"border":"2rpx solid #eeeeee","padding":"0 20rpx","margin":"0 0 24rpx 0","borderRadius":"0px","borderWidth":"0 0 2rpx 0","width":"100%","height":"auto"}' v-if="tableName=='xueyedaoshi'"  @change="xueyedaoshixingbieChange" :value="xueyedaoshixingbieIndex" :range="xueyedaoshixingbieOptions">
				<view :style='{"width":"100%","lineHeight":"88rpx","fontSize":"28rpx","color":"#666666"}' class="uni-input">{{ruleForm.xingbie?ruleForm.xingbie:"请选择性别"}}</view>
			</picker>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='xueyedaoshi'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#666666","borderRadius":"0px","background":"#ffffff","borderWidth":"0 0 2rpx 0","width":"100%","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.xueyuan" type="text" class="uni-input" name="" placeholder="学院" />
			</view>
			<view :style='{"width":"100%","margin":"0 0 24rpx 0","height":"auto"}' v-if="tableName=='xueyedaoshi'" class="uni-form-item uni-column">
				<input :style='{"border":"2rpx solid #eeeeee","padding":"0px 24rpx 0 24rpx","margin":"0 0 0px 0","color":"#666666","borderRadius":"0px","background":"#ffffff","borderWidth":"0 0 2rpx 0","width":"100%","fontSize":"28rpx","height":"88rpx"}'  v-model="ruleForm.dianhuahaoma" type="text" class="uni-input" name="" placeholder="电话号码" />
			</view>
			<button :style='{"border":"0","padding":"0 0 0 0","margin":"0 0 24rpx 0","color":"#ffffff","borderRadius":"60rpx","background":"#75ebde","width":"100%","lineHeight":"88rpx","fontSize":"32rpx","height":"88rpx"}' class="btn-submit" @tap="register" type="primary">注册</button>
		</view>
	</view>
</view>
</template>

<script>
    import multipleSelect from "@/components/momo-multipleSelect/momo-multipleSelect";
	export default {
		data() {
			return {
                xueshengxingbieOptions: [],
                xueshengxingbieIndex: 0,
                xueyedaoshixingbieOptions: [],
                xueyedaoshixingbieIndex: 0,
				ruleForm: {
                xuehao: '',
                mima: '',
                xueshengxingming: '',
                touxiang: '',
                xingbie: '',
                zhuanye: '',
                banji: '',
                lianxifangshi: '',
                daoshigonghao: '',
                mima: '',
                daoshixingming: '',
                touxiang: '',
                xingbie: '',
                xueyuan: '',
                dianhuahaoma: '',
				},
				tableName:""
			}
		},
        components: {
            multipleSelect
        },
        computed: {
            baseUrl() {
                return this.$base.url;
            },
        },
		async onLoad() {
			let res = [];
			let table = uni.getStorageSync("loginTable");
            this.tableName = table;

			// 自定义下拉框值
			if(this.tableName=='xuesheng'){
                this.xueshengxingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.xueshengxingbieOptions[0]
			}
			// 自定义下拉框值
			if(this.tableName=='xueyedaoshi'){
                this.xueyedaoshixingbieOptions = "男,女".split(',');
				this.ruleForm.xingbie=this.xueyedaoshixingbieOptions[0]
			}
			
			this.styleChange()
		},
		methods: {

            xueshengtouxiangTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.touxiang = 'file/' + res.file;
                    _this.$forceUpdate();
                });
            },
            // 下拉变化
            xueshengxingbieChange(e) {
                    this.xueshengxingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.xueshengxingbieOptions[this.xueshengxingbieIndex]
            },
            xueyedaoshitouxiangTap() {
                let _this = this;
                this.$api.upload(function(res) {
                    _this.ruleForm.touxiang = 'file/' + res.file;
                    _this.$forceUpdate();
                });
            },
            // 下拉变化
            xueyedaoshixingbieChange(e) {
                    this.xueyedaoshixingbieIndex = e.target.value
                    this.ruleForm.xingbie = this.xueyedaoshixingbieOptions[this.xueyedaoshixingbieIndex]
            },
            toggleTab(str) {
                this.$refs[str].show();
            },

			styleChange() {
				this.$nextTick(()=>{
					document.querySelectorAll('.radioText').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"color":"#666666","display":"inline-block"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.radioTextActive').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"color":"#75ebde","display":"inline-block"}
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
					  const icon = {"color":"#75ebde"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.uni-radio-input').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"border":"2rpx solid #eeeeee","outlineColor":"#666666","background":"#ffffff","display":"inline-block"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.uni-radio-input-checked').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"border":"2rpx solid #75ebde","textAlign":"center","background":"#75ebde","display":"inline-block"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.uni-checkbox-input').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"border":"2rpx solid #eeeeee","borderColor":"#666666","borderRadius":"40rpx","background":"#ffffff"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
					document.querySelectorAll('.uni-checkbox-input-checked').forEach(el => {
					  el.removeAttribute('style')
					  const icon = {"borderColor":"#75ebde","color":"#ffffff","borderRadius":"40rpx","background":"#75ebde"}
					  Object.keys(icon).forEach((key) => {
						el.style[key] = icon[key]
					  })
					})
				})
			},
			// 获取uuid
			getUUID () {
				return new Date().getTime();
			},
			// 注册
			async register() {
                if(`xuesheng` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
                if(`xueyedaoshi` == this.tableName && (this.ruleForm.mima!=this.ruleForm.mima2)){
                    this.$utils.msg(`两次密码输入不一致`);
                    return
                }
				if(`xueyedaoshi` == this.tableName && this.ruleForm.dianhuahaoma&&(!this.$validate.isMobile(this.ruleForm.dianhuahaoma))){
					this.$utils.msg(`电话号码应输入手机格式`);
					return
				}
				await this.$api.register(`${this.tableName}`, this.ruleForm);
				this.$utils.msgBack('注册成功');;
			}
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
</style>
