package io.conduit.api

import com.hackernight.api.ConduitClient
import junit.framework.Assert.assertNotNull
import org.junit.Test

class ConduitClientTest {

    val conduitClient = ConduitClient()

   @Test
   fun getArticles(){
       val articles = conduitClient.api.getAllArticles()
       assertNotNull(articles.body()?.articles)
   }
}