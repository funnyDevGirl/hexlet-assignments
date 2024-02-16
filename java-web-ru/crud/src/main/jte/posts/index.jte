@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link active" aria-current="page" href="${NamedRoutes.postsPath()}">Все посты</a>
            </li>
        </ul>

        <br>

        @if(page.getPosts().isEmpty())
            <p>Пока не добавлено ни одного поста!</p>
        @else
            <table class="table">
                <thead>
                <tr>
                    <th>Post's id</th>
                    <th>Name</th>
                </tr>
                </thead>
                <tbody>
                @for(var post : page.getPosts())
                    <tr>
                        <td><a href="${NamedRoutes.postPath(post.getId())}">${post.getId()}</a></td>
                        <td><a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a></td>
                    </tr>
                @endfor
                </tbody>
            </table>
        @endif

        <br>

        <nav aria-label="...">
            <ul class="pagination">
                @if (page.hasPreviousPage())
                    <li class="page-item">
                        <a class="page-link" href="${NamedRoutes.postsPath()}?page=${page.getPage() - 1}">Previous</a>
                    </li>
                @else
                    <li class="page-item disabled">
                        <a class="page-link" href="${NamedRoutes.postsPath()}?page=${page.getPage() - 1}">Previous</a>
                    </li>
                @endif
                @if (page.hasNextPage())
                    <li class="page-item">
                        <a class="page-link" href="${NamedRoutes.postsPath()}?page=${page.getPage() + 1}">Next</a>
                    </li>
                @else
                    <li class="page-item disabled">
                        <a class="page-link" href="${NamedRoutes.postsPath()}?page=${page.getPage() + 1}">Next</a>
                    </li>
                @endif
            </ul>
        </nav>
    </div>
`
)