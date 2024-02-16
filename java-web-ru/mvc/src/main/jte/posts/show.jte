@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage page

@template.layout.page(
    content = @`
        <main>
            <div class="mx-auto p-4 py-md-5">
                <h2>${page.getPost().getName()}</h2>
            </div>

            <div class="mx-auto p-4 py-md-5">
                ${page.getPost().getBody()}
            </div>
            <!-- BEGIN -->
            <br>
            <ul class="nav">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="${NamedRoutes.editPostPath(page.getPost().getId())}">Edit</a>
                </li>
            </ul>
            <!-- END -->
        </main>
    `
)
