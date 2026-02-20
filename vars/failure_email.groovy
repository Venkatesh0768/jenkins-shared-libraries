def call(String email, String subject, String errorMessage) {

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
                    max-width: 650px;
                    margin: auto;
                    background: #ffffff;
                    border-radius: 10px;
                    box-shadow: 0 6px 18px rgba(0,0,0,0.1);
                    overflow: hidden;
                }
                .header {
                    background: #dc3545;
                    color: white;
                    padding: 22px;
                    text-align: center;
                    font-size: 22px;
                    font-weight: bold;
                }
                .content {
                    padding: 25px;
                    color: #333;
                }
                .info {
                    background: #f8d7da;
                    padding: 12px;
                    border-radius: 6px;
                    margin-top: 12px;
                    font-size: 14px;
                }
                .error-box {
                    background: #fff3f3;
                    border-left: 4px solid #dc3545;
                    padding: 12px;
                    margin-top: 15px;
                    font-size: 14px;
                    color: #721c24;
                }
                .button {
                    display: inline-block;
                    margin-top: 20px;
                    padding: 10px 18px;
                    background: #dc3545;
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
                    ❌ Build Failed
                </div>

                <div class="content">
                    <p><strong>Project:</strong> ${env.JOB_NAME}</p>

                    <div class="info">
                        <p><strong>Build Number:</strong> ${env.BUILD_NUMBER}</p>
                        <p><strong>Branch:</strong> ${env.GIT_BRANCH ?: 'N/A'}</p>
                        <p><strong>Triggered By:</strong> ${env.BUILD_USER ?: 'System'}</p>
                        <p><strong>Build URL:</strong> ${env.BUILD_URL}</p>
                    </div>

                    <div class="error-box">
                        <strong>Error Summary:</strong><br/>
                        ${errorMessage}
                    </div>

                    <a href="${env.BUILD_URL}" class="button">
                        View Console Output
                    </a>
                </div>

                <div class="footer">
                    Jenkins CI/CD Failure Notification • ${new Date()}
                </div>
            </div>
        </body>
        </html>
        """
    )
}
