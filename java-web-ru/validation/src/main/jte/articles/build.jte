@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(
content = @`
    <div class="container" align="left">
        @if(page.getErrors() != null)
            <ul>
                @for(var validator : page.getErrors().values())
                    @for(var error : validator)
                        <li>${error.getMessage()}</li>
                    @endfor
                @endfor
            </ul>
        @endif

        <form action="/articles" method="post">
            <div>
                <label>
                    <p>Title</p>
                    <input type="text" name="title" value="${page.getTitle()}"/>
                </label>
            </div>
            <br>
            <div>
                    <label>
                        <p>Text</p>
                        <textarea name="content" value="${page.getContent()}"></textarea>
                    </label>
            </div>
            <br>
            <input type="submit" value="Post" />
        </form>
    </div>
`
)