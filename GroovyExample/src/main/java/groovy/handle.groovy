def handle = { Map<String, String> params ->
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

handle(params)
//def add(int x, int y) {
//    return x + y
//}