package io.github.terickson87.ModulithWithUsersStarter

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
	fromApplication<ModulithWithUsersStarterApplication>().with(TestcontainersConfiguration::class).run(*args)
}
