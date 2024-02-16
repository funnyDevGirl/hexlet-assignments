@import exercise.dto.posts.EditPostPage
@import exercise.util.NamedRoutes
@param EditPostPage page

@template.layout.page(
content = @`
    <div align="left">
        @if(page.getErrors() != null)
            <div class="mb-3">
                <ul>
                    @for(var validator : page.getErrors().values())
                        @for(var error : validator)
                            <li>${error.getMessage()}</li>
                        @endfor
                    @endfor
                </ul>
            </div>
        @endif
    </div>

    <div class="mx-auto p-4 py-md-5">
        <form action="${NamedRoutes.postPath(page.getId())}" method="post">
            <div class="mb-3">
                <label class="form-label">
                    <p>Название</p>
                    <input type="text" class="form-control" name="name" value="${page.getName()}" />
                </label>
            </div>
            <br>
            <div>
                <label class="form-label">
                    <p>Содержание</p>
                    <textarea class="form-control" name="body">${page.getBody()}</textarea>
                </label>
            </div>
            <br>
            <input type="submit" class="btn btn-primary" value="Обновить" />
        </form>
    </div>
`
)