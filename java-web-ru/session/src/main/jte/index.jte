@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(content = @`
    @if(page != null && page.getName() != null)
        <h2>Hello, ${page.getName().toString()}!</h2>
        <form action="${NamedRoutes.logoutPath()}" method="post">
            <input type="submit" value="Выйти">
        </form>
    @else
        <h2>Hello!</h2>
        <form action="${NamedRoutes.buildSessionPath()}" method="get">
            <input type="submit" value="Войти">
        </form>
    @endif
    `
)