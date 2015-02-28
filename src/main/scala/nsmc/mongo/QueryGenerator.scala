package nsmc.mongo

import com.mongodb.DBObject
import com.mongodb.casbah.Imports._

class QueryGenerator {
  def makeProjection(requiredColumns: Array[String]) : DBObject = {
    val builder = MongoDBObject.newBuilder
    // add all specified columns remembering that _id is in by default
    // and thus has to be explicitly suppressed if not needed
    requiredColumns.foreach(k => if (k != "_id") builder += (k -> 1))
    if (!requiredColumns.contains("_id")) builder += "_id" -> 0
    builder.result()
  }
}
