class CAPS {

    static def random = new Random(System.currentTimeMillis())

    int characteristicSum = 0
    boolean checkActive(Map preset){
        characteristicSum = Math.max(preset.get("energy"), 0) + Math.max(preset.get("impulsivity"), 0)
        return (characteristicSum > 4)
    }

    Map morphPhrase(Map phrase){
        if (characteristicSum <= 4 || random.nextInt(characteristicSum) >= 4)
            phrase.put("text", phrase.get("text").toUpperCase())

        return phrase
    }

    String getName(String locale){
        switch (locale){
            case "ru": return "Капс"
            default:   return "Caps"
        }
    }
}