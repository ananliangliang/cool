package pers.ananliangliang.cool.common.exception

class SysException(
    override val message: String,
) : CoolException(message) {
    override val tag: String = "系统异常"
}