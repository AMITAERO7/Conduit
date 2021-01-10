package io.conduit.api

import com.hackernight.api.ConduitClient
import com.hackernight.api.model.entities.UserCreds
import com.hackernight.api.model.requests.SignUpRequest
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ConduitClientTest {

    val conduitClient = ConduitClient()

   @Test
   fun getArticles(){
       runBlocking {
           val articles = conduitClient.api.getAllArticles()
           assertNotNull(articles.body()?.articles)
       }
   }


    @Test
    fun getArticlesByAuthor(){
        runBlocking {
            val articles = conduitClient.api.getAllArticles(author = "444")
            assertNotNull(articles.body()?.articles)
        }
    }


    @Test
    fun getArticlesByTags(){
        runBlocking {
            val articles = conduitClient.api.getAllArticles(tag = "dragon")
            assertNotNull(articles.body()?.articles)
        }
    }

    @Test
    fun singUpUser(){
        val userCreds = UserCreds("amitaero77@gmail.com","12345@amit","kumarami")
        runBlocking {
            val resp = conduitClient.api.signUpUser(SignUpRequest(userCreds))
            assertEquals(userCreds.username,resp.body()?.user?.username)
        }
    }
}