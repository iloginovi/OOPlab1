fun main() {
    val str = """
            1. 109991, Omsk, street. Teatralnaya, h. 7
                 2. 739549, Saint-Petersburg, street. Nevskiy avenue, h. 67        
            3. 100346, Volgograd, street. Eliseeva, h. 8           
    """
    val addressList: List<Address> = parseAddresses(str)
    println("2. ${addressList[2].postcode}, ${addressList[1].city}, street. ${addressList[1].street}, h. ${addressList[2].houseNumber}.")
    var maxPostcode = addressList[0]
    var minPostcode = addressList[0]
    var longNameStreet = addressList[0]
    var shortNameStreet = addressList[0]
    for (i in addressList.indices) {
        if (maxPostcode.postcode.toInt() < addressList[i].postcode.toInt())
            maxPostcode = addressList[i]
        if (minPostcode.postcode.toInt() > addressList[i].postcode.toInt())
            minPostcode = addressList[i]
        if (longNameStreet.street.length < addressList[i].street.length)
            longNameStreet = addressList[i]
        if (shortNameStreet.street.length > addressList[i].street.length)
            shortNameStreet = addressList[i]
    }
    println("Address with max postcode: ${maxPostcode.postcode}, ${maxPostcode.city}, street. ${maxPostcode.street}, h. ${maxPostcode.houseNumber}.")
    println("Address with min postcode: ${minPostcode.postcode}, ${minPostcode.city}, street. ${minPostcode.street}, h. ${minPostcode.houseNumber}.")
    println("Address with shortest street name ${shortNameStreet.postcode}, ${shortNameStreet.city}, street. ${shortNameStreet.street}, h. ${shortNameStreet.houseNumber}.")
    println("Address with longest street name ${longNameStreet.postcode}, ${longNameStreet.city}, street. ${longNameStreet.street}, h. ${longNameStreet.houseNumber}.")
}
//