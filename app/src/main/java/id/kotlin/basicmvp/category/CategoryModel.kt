package id.kotlin.basicmvp.category

data class CategoryModel(
    var category: CategoryItemModel,
    var glass: GlassItemModel,
    var ingredient: IngredientItemModel
)

data class CategoryItemModel(var contents: List<String>)
data class GlassItemModel(var contents: List<String>)
data class IngredientItemModel(var contents: List<String>)