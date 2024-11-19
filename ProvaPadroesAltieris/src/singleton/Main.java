package singleton;

public class Main {
    public static void main(String[] args) {
    	
    	 // 1. Deve existir apenas uma instância deste componente durante toda a execução do programa.
    	System.out.println("1");
        GlobalConfig config1 = GlobalConfig.getInstance();
        GlobalConfig config2 = GlobalConfig.getInstance();
        System.out.println("Ambas referências apontam para a mesma instância? " + (config1 == config2));
    	
        
        // 2. O componente deve permitir o acesso às configurações globais de qualquer parte do sistema.
        System.out.println("\n2");
        GlobalConfig config = GlobalConfig.getInstance();
        System.out.println("Nome da aplicação: " + config.getApplicationName());
        System.out.println("Versão da aplicação: " + config.getVersion());
        System.out.println("Máximo de dispositivos permitidos: " + config.getMaxDevices());
        
        //4. O sistema deve ser robusto e evitar a criação de múltiplas instâncias do componente, mesmo em ambientes multithread.  
        System.out.println("\n3");
        Runnable task = () -> {
            GlobalConfig threadConfig = GlobalConfig.getInstance();
            System.out.println("HashCode da instância na thread: " + threadConfig.hashCode());
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();


    }
}
