@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
content = @`
    <h2>User</h2>

    <table>
        <tr>
            <th>FirstName</th>
            <th>LastName</th>
            <th>Email</th>
        </tr>
        <tr>
            <td>${page.getUser().getFirstName()}</td>
            <td>${page.getUser().getLastName()}</td>
            <td>${page.getUser().getEmail()}</td>
        </tr>
    </table>
`,
footer = @`
    <footer>
        <p>Author: Alina Tarasova</p>
        <p><a href="https://github.com/funnyDevGirl">My GitHub profile</a></p>
    </footer>
`
)
