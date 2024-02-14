@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
    content = @`
        <h2>User</h2>
        <table>
            <thead>
                <tr>
                    <th>FirstName LastName</th>
                    <th>Email</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</td>
                    <td>${page.getUser().getEmail()}</td>
                </tr>
            </tbody>
        </table>
    `,
    footer = @`
        <p>Alina Tarasova</p>
        <p><a href="https://github.com/funnyDevGirl">My GitHub profile</a></p>
    `
)
