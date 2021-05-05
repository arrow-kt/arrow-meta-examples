package io.arrowkt.example

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.nio.file.Paths
import kotlin.io.path.exists


class NewMultipleSourceTests {
  @Test
  fun `multiple sources are created`() {
    val generatedDirPath = Paths.get(System.getProperty("user.dir"), "build", "generated")

    assertTrue(Paths.get(generatedDirPath.toString(), "source", "kapt", "main", "NewMultipleSource_Generated.kt").exists())
    assertTrue(Paths.get(generatedDirPath.toString(), "custom", "directory", "NewMultipleSource_Generated_2.kt").exists())
  }
}