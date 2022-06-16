package com.example.budfit

/**
 * Enum trieda obsahujuca poraviny s hodnotou kalorii
 */
enum class Jedla(val meno: String,val kalorie: Float) {
    KURA("kuracie",1.5F),
    HOVADZIE("hovadzie",1.39F),
    BRAVCOVE("bravcove",2.3F),
    TOFU("tofu",1.3F),
    SOJOVE("sojove",3.16F),
    RYZA("ryza",1.26F),
    ZAMIAKY("zemiaky", 1.1F),
    BATATY("bataty",0.82F),
    KUSKUS("kuskus",1.2F),
    CESTOVINY("cestoviny",1.33F),
    PAPRIKA("paprika",0.32F),
    PARADAJKA("paradajka",0.25F),
    UHORKA("uhorka",0.14F),
    SALAT("salat",0.16F),
    MRKVA("mrkva",0.4F),
    JABLKO("jablko",0.68F),
    BANAN("banan",0.94F),
    HRUSKA("hruska",0.58F),
    HROZNO("hrozno",0.77F),
    KIWI("kiwi",0.71F),
    OVSENEVLOCKY("ovsene vlocky",3.82F),
    CHLEBA("chleba",2.17F),
    ROZOK("rozok",2.86F),
    BAGETA("bageta",3.02F),
    VYBRAT("vybrat",0F)
}