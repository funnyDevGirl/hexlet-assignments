@import exercise.dto.posts.PostPage
@param PostPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <h2><a href="/index">All Posts</a></h2>

        <h2>Пост ${page.getPost().getId()}</h2>
        <table>
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