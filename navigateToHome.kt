private fun navigateToHome() {
    val intent = Intent(this, MainActivity::class.java).apply {
        // Flags para voltar à raiz da aplicação e limpar as Activities acima
        flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
    }
    startActivity(intent)
}