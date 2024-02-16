@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <a href="${NamedRoutes.postsPath()}">Все посты</a>

        <h3>Пост ${page.getPost().getId()}</h3>
        <table class="container">
            <tr>
                <th>name</th>
                <th>body</th>
            </tr>
            <tr>
                <td>${page.getPost().getName()}</td>
                <td>${page.getPost().getBody()}</td>
            </tr>
        </table>
    </div>
`
)