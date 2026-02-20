def call() {
    emailext(
        to: "rapoluvenky8@gmail.com",
        subject: "Jenkins Test Email",
        body: "If you receive this email, Jenkins SMTP is working."
    )
}
