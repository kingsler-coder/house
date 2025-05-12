package com.kingsler.manyumba.model
class Property {
    var id: Int = 0
    var title: String=""
    var location: String=""
    var price: Double=0.0
    var imageUrl: String=""
    var description: String=""
    var type: String=""
    var bedrooms: Int=0
    var bathrooms: Int=0
    var size: String=""

    constructor(
        id: Int,
        title: String,
        location: String,
        price: Double,
        imageUrl: String,
        description: String,
        type: String,
        bedrooms: Int,
        bathrooms: Int,
        size: String
    )

    {
        this.id = id
        this.title = title
        this.location = location
        this.price = price
        this.imageUrl = imageUrl
        this.description = description
        this.type = type
        this.bedrooms = bedrooms
        this.bathrooms = bathrooms
        this.size = size
    }
constructor()


}
