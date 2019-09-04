// 不带参数的groovy方法
def sayHello(name) {
	println "Hello " + name + "."

	// 如果不写return, groovy方法的默认最后一行为 方法的返回值
	//return "GroovyShellTest2中的sayHello()方法的返回值"
	"GroovyShellTest2中的sayHello()方法的返回值"
}

// 运行groovy方法
sayHello(name)

