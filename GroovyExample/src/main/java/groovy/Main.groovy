package groovy

/**
 * Created by dj on 2017/2/20.
 */
class Main {


    public static void main(String[] args) {

        Closure<LinkedHashMap> handle = { Map<String, String> params ->
            String site = params.get("site")
            def siteNotSaleCabins = []
            switch (site) {
                case "747":
                    siteNotSaleCabins.add("U")
                    break
                case "test":
                    siteNotSaleCabins.add("U")
                    siteNotSaleCabins.add("Z")
                    break
                default:
                    break
            }

            def retMap = [:]
            retMap.put("siteNotSaleCabins", siteNotSaleCabins)
            return retMap
        }

        Closure<String> check = { Map<String, String> params ->
            if (params == null) {
                return "params"
            }

            if (params.get("site") == null) {
                return "site"
            }

            return null
        }

        println check([:])
        println check(["site": "715"])
        println handle(["site": "test"])
        println handle(["site": "747"])
        println handle(["site": "715"])

        check = { Map<String, String> params ->
            if (params == null)
                return "params"

            if (params.get("cabinType") == null)
                return "cabinType"

            return null
        }

        handle = { Map<String, String> params ->
            String cabinType = params.get("cabinType")
            switch (cabinType) {
                case "NN":
                    return "普通经济舱"
                case "NW":
                    return "明珠经济舱"
                case "NY":
                    return "全价经济舱"
                default:
                    return ""
            }
        }

        println "lalala"
        println handle(["cabinType": "NN"])

    }
}
