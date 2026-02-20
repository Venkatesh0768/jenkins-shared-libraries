def call(String email, String subject, String customMessage) {

    emailext(
        to: email,
        subject: subject,
        mimeType: 'text/html',
        body: """
        <html>
        <head>
            <style>
                body {
                    font-family: Arial, sans-serif;
                    background-color: #f4f6f8;
                    padding: 20px;
                }
                .card {
                    max-width: 600px;
                    margin: auto;
                    background: #ffffff;
                    border-radius: 10px;
                    box-shadow: 0 4px 12px rgba(0,0,0,0.1);
                    overflow: hidden;
                }
                .header {
                    background: #28a745;
                    color: white;
                    padding: 20px;
                    text-align: center;
                    font-size: 22px;
                    font-weight: bold;
                }
                .content {
                    padding: 20px;
                    color: #333;
                }
                .info {
                    background: #f1f1f1;
                    padding: 10px;
                    border-radius: 6px;
                    margin-top: 10px;
                    font-size: 14px;
                }
                .button {
                    display: inline-block;
                    margin-top: 20px;
                    padding: 10px 18px;
                    background: #007bff;
                    color: white !important;
                    text-decoration: none;
                    border-radius: 6px;
                }
                .footer {
                    text-align: center;
                    padding: 15px;
                    font-size: 12px;
                    color: #777;
                }
            </style>
        </head>

        <body>
            <div class="card">
                <div class="header">
                    ✅ Build Successful
                </div>

                <div class="content">
                    <p><strong>Project:</strong> ${env.JOB_NAME}</p>

                    <div class="info">
                        <p><strong>Build Number:</strong> ${env.BUILD_NUMBER}</p>
                        <p><strong>Branch:</strong> ${env.GIT_BRANCH ?: 'N/A'}</p>
                        <p><strong>Triggered By:</strong> ${env.BUILD_USER ?: 'System'}</p>
                    </div>

                    <p style="margin-top:15px;">
                        ${customMessage}
                    </p>

                    <a href="${env.BUILD_URL}" class="button">
                        View Build Details
                    </a>
                </div>

                <div class="footer">
                    Jenkins CI/CD Notification • ${new Date()}
                </div>
            </div>
        </body>
        </html>
        """
    )
}
