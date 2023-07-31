package pers.ananliangliang.cool.common.exception

class BizException(
    override val message: String,
) : CoolException(message) {
    override val tag: String = "业务异常"
}