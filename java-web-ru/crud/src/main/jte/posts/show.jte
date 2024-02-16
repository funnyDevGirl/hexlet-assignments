@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="${NamedRoutes.postsPath()}">Все посты</a>
            </li>
        </ul>

        <br>

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