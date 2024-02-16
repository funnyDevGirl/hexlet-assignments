@import exercise.util.NamedRoutes;

@template.layout.page(
    content = @`
        <div class="mx-auto p-4 py-md-5">
            <main>
                <ul class="nav">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="${NamedRoutes.postsPath()}">Все посты</a>
                    </li>
                </ul>
            </main>
        </div>
    `
)
