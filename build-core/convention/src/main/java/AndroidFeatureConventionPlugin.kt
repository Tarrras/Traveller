import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.kapt")
            }
            extensions.configure<LibraryExtension> {
                defaultConfig {
                    //todo add custom runner if needed
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }
            }

            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            dependencies {
                // TODO : Remove this dependency once we upgrade to Android Studio Dolphin b/228889042
                // These dependencies are currently necessary to render Compose previews
                add(
                    "debugImplementation",
                    libs.findLibrary("androidx.customview.poolingcontainer").get()
                )
            }
        }
    }
}