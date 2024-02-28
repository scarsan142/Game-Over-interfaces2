package com.marisma.gameover

class JuegoProvider {
    companion object{
        val listaJuegos = listOf<Juego>(
            Juego(
                0,
                "Xenoblade Chronicles",
                "JRPG",
                "Monolith Software",
                10,
                "https://fs-prod-cdn.nintendo-europe.com/media/images/10_share_images/games_15/nintendo_switch_4/H2x1_NSwitch_XenobladeChroniclesDefinitiveEdition_image1600w.jpg"
            ),Juego(
                1,
                "Viva Piñata",
                "Simulador",
                "RARe",
                1,
                "https://store-images.s-microsoft.com/image/apps.39018.69993262899909428.0190d6b7-60eb-4d3f-bd16-b44c0e303861.04139d83-ad8c-48d8-93a3-db75ade8684c?q=90&w=480&h=270"
            ),Juego(
                2,
                "Call of Duty Black Ops 2",
                "Accion",
                "Treyarch",
                8,
                "https://cdn.dlcompare.com/game_tetiere/upload/gameimage/file/call-of-duty-black-ops-2-file-48980dd1.jpeg"
            ),Juego(
                3,
                "Cyberpunk 2077",
                "RPG",
                "CD Projeckt Red",
                6,
                "https://i.blogs.es/b109e9/cyberpunk2077-johnny-v-rgb_en/1366_2000.jpg"
            ),Juego(
                4,
                "Lethal Company",
                "Terror",
                "Zeekers",
                8,
                "https://cdn.cloudflare.steamstatic.com/steam/apps/1966720/capsule_616x353.jpg?t=1700231592"
            ),Juego(
                5,
                "Yakuza 0",
                "Accion",
                "RGG Studio",
                10,
                "https://cdn-products.eneba.com/resized-products/T6WgqoF_350x200_1x-0.jpg"
            ),Juego(
                6,
                "League of Legends",
                "MOBA",
                "Riot Games",
                7,
                "https://cdn1.epicgames.com/offer/24b9b5e323bc40eea252a10cdd3b2f10/EGS_LeagueofLegends_RiotGames_S1_2560x1440-80471666c140f790f28dff68d72c384b"
            ),Juego(
                7,
                "Persona 5",
                "JRPG",
                "Atlus",
                9,
                "https://cdn.akamai.steamstatic.com/steam/apps/1687950/capsule_616x353.jpg?t=1688115070"
            ),Juego(
                8,
                "For Honor",
                "Accion",
                "Ubisoft",
                6,
                "https://image.api.playstation.com/gs2-sec/appkgo/prod/CUSA05264_00/2/i_e6ab917b766cfda7b368e5ab4d2e386de33b4886b4e181efa8ce35dec7f18ed9/i/icon0.png"
            ),Juego(
                9,
                "Metal Gear Solid 3",
                "Aventura",
                "Konami",
                10,
                "https://static.wikia.nocookie.net/metalgear/images/f/fe/Carátula_MGS3.png/revision/latest?cb=20100630091542&path-prefix=es"
            )
        )

        fun buscarJuegoPorId(id: Int): Juego? {
            return listaJuegos.find { it.id == id }
        }
    }
}