object Config {
    const val baseApplicationId = "com.baltajmn.news"

    object Feature {
        const val Splash = "$baseApplicationId.features.splash"
        const val Preferences = "$baseApplicationId.features.preferences"
        const val Home = "$baseApplicationId.features.home"
        const val Article = "$baseApplicationId.features.article"
        const val Top = "$baseApplicationId.features.top"
        const val Settings = "$baseApplicationId.features.settings"
    }

    object Core {
        const val Auth = "$baseApplicationId.core.auth"
        const val Common = "$baseApplicationId.core.common"
        const val Data = "$baseApplicationId.core.data"
        const val Database = "$baseApplicationId.core.database"
        const val Design = "$baseApplicationId.core.design"
        const val Navigation = "$baseApplicationId.core.navigation"
        const val Network = "$baseApplicationId.core.network"
        const val Persistence = "$baseApplicationId.core.persistence"
    }

    object Tests {
        const val SharedTests = "$baseApplicationId.test.sharedTests"
    }

}