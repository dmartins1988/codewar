package com.example.davidmartins.codewar.data.models

import com.google.gson.annotations.SerializedName

data class Ranks(
        @SerializedName("languages")
        val languages: Languages,
        @SerializedName("overall")
        val overall: Overall
)