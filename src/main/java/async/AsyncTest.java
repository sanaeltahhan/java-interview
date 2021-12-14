package async;

import io.vavr.Tuple2;
import io.vavr.collection.List;
import io.vavr.control.Option;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * You should complete the function in this class
 */
class AsyncTest {

  private static List<Enterprise> enterprises = List.of(
      new Enterprise("ent_1", "Google", "ceo_2"),
      new Enterprise("ent_2", "Facebook", "ceo_1")
  );

  private static List<Ceo> ceos = List.of(
      new Ceo("ceo_1", "Mark"),
      new Ceo("ceo_2", "Sundar"),
      new Ceo("ceo_3", "Bill")
  );

  public static CompletableFuture<Option<Ceo>> getCeoById(String ceo_id) {

    return CompletableFuture.supplyAsync(() -> {
      return ceos.find(ceo -> ceo.getId().equals(ceo_id));
    });
  }

  public static CompletableFuture<Option<Enterprise>> getEnterpriseByCeoId(String ceo_id) {

    return CompletableFuture.supplyAsync(() -> {
      return enterprises.find(enterprise -> enterprise.getCeo_id().equals(ceo_id));
    });
  }

  public static CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> getCEOAndEnterprise(String ceo_id)
      throws ExecutionException, InterruptedException {

    // initialisation tuple sans valeur qu'on modifira par la suite, pour ce faire on a ajouter un constructeur vide dans la classe Ceo et Enterprise
    Tuple2 <Option<Ceo>, Option<Enterprise>> tuple = new Tuple2<Option<Ceo>, Option<Enterprise>>(new Ceo(), new Enterprise());

    return CompletableFuture.supplyAsync(() -> {

      try {
        // On modifie le tuple avec les valeurs renvoyées par getCeoById et getEnterpriseByCeoId
        return tuple.update1(getCeoById(ceo_id).get()).update2(getEnterpriseByCeoId(ceo_id).get());
      } catch (InterruptedException e) {
        e.printStackTrace();
      } catch (ExecutionException e) {
        e.printStackTrace();
      }
      return null;
    });
  }
}
