import java.time.LocalDate
import java.time.format.DateTimeFormatter

plugins {
	id("java")
	id("application")
	id("jacoco")
}

group = "com.github.hummel"
version = LocalDate.now().format(DateTimeFormatter.ofPattern("yy.MM.dd"))

val embed: Configuration by configurations.creating

dependencies {
	embed("com.formdev:flatlaf:latest.release")
	embed("com.formdev:flatlaf-intellij-themes:latest.release")
	implementation("com.formdev:flatlaf:latest.release")
	implementation("com.formdev:flatlaf-intellij-themes:latest.release")
	testImplementation("org.junit.jupiter:junit-jupiter:latest.release")
	testImplementation(project(":"))
}

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(11)
	}
}

application {
	mainClass = "com.github.hummel.bose.Main"
}

tasks {
	named<JavaExec>("run") {
		standardInput = System.`in`
	}
	test {
		useJUnitPlatform()
	}
	jacocoTestReport {
		reports {
			xml.required = true
		}
	}
	jar {
		manifest {
			attributes(
				mapOf(
					"Main-Class" to "com.github.hummel.bose.Main"
				)
			)
		}
		from(embed.map {
			if (it.isDirectory) it else zipTree(it)
		})
		duplicatesStrategy = DuplicatesStrategy.EXCLUDE
	}
	withType<JavaCompile>().configureEach {
		options.encoding = "UTF-8"
	}
}
