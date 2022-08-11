package com.example.translateapp.data

import com.google.gson.annotations.SerializedName

data class TranslateItemResponse(

	@field:SerializedName("TranslateItemResponse")
	val translateItemResponse: List<TranslateItemResponseItem?>? = null
)

data class MeaningsItem(

	@field:SerializedName("synonyms")
	val synonyms: List<Any?>? = null,

	@field:SerializedName("partOfSpeech")
	val partOfSpeech: String? = null,

	@field:SerializedName("antonyms")
	val antonyms: List<Any?>? = null,

	@field:SerializedName("definitions")
	val definitions: List<DefinitionsItem?>? = null
)

data class License(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class DefinitionsItem(

	@field:SerializedName("synonyms")
	val synonyms: List<Any?>? = null,

	@field:SerializedName("antonyms")
	val antonyms: List<Any?>? = null,

	@field:SerializedName("definition")
	val definition: String? = null,

	@field:SerializedName("example")
	val example: String? = null
)

data class PhoneticsItem(

	@field:SerializedName("sourceUrl")
	val sourceUrl: String? = null,

	@field:SerializedName("license")
	val license: License? = null,

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("audio")
	val audio: String? = null
)

data class TranslateItemResponseItem(

	@field:SerializedName("license")
	val license: License? = null,

	@field:SerializedName("phonetic")
	val phonetic: String? = null,

	@field:SerializedName("phonetics")
	val phonetics: List<PhoneticsItem?>? = null,

	@field:SerializedName("word")
	val word: String? = null,

	@field:SerializedName("meanings")
	val meanings: List<MeaningsItem?>? = null,

	@field:SerializedName("sourceUrls")
	val sourceUrls: List<String?>? = null
)
