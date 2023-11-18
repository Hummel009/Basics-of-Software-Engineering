import java.time.LocalDate
import java.time.format.DateTimeFormatter

plugins {
	id("java")
	id("application")
	id("jacoco")
}

group = "org.example"
version = "v" + LocalDate.now().format(DateTimeFormatter.ofPattern("yy.MM.dd"))

repositories {
	mavenCentral()
}

val embed: Configuration by configurations.creating

dependencies {
	embed("com.formdev:flatlaf:3.2.1")
	embed("com.formdev:flatlaf-intellij-themes:3.2.1")
	implementation("com.formdev:flatlaf:3.2.1")
	implementation("com.formdev:flatlaf-intellij-themes:3.2.1")
	testImplementation("org.junit.jupiter:junit-jupiter:5.9.2")
	testImplementation(project(":"))
}

application {
	mainClass = "hummel.Main"
}

tasks {
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
					"Main-Class" to "hummel.Main"
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