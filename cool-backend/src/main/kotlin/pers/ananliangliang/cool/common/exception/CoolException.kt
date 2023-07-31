package pers.ananliangliang.cool.common.exception

abstract class CoolException(message: String) : RuntimeException(message) {

    abstract val tag: String

}