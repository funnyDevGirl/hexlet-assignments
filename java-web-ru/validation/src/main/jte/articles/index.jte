@import exercise.dto.articles.ArticlesPage
@param ArticlesPage page

@template.layout.page(
    content = @`
        <div class="mx-auto p-4 py-md-5">
            <main>
                <h1>Все статьи</h1>

                <div class="mb-3">
                    <a href="/articles/build">Создать новую статью</a>
                </div>

                <table class="table table-striped">
                    @for(var article : page.getArticles())
                        <tr>
                            <td>
                                ${article.getId()}
                            </td>
                            <td>
                                ${article.getTitle()}
                            </td>
                            <td>
                                ${article.getContent()}
                            </td>
                        </tr>
                    @endfor
                </table>
            </main>
        </div>
    `
)
