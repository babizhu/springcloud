package com.bbz.learn.spring.user_module

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class UserModuleApplicationTests {
    @Autowired
    private lateinit var mvc: MockMvc

    @Test
    fun contextLoads() {
    }

    @Test
    fun mvcTest() {
        this.mvc.perform(get("/")).andExpect(status().isOk)
                .andExpect(content().string("hello UserModule"))
    }


}
