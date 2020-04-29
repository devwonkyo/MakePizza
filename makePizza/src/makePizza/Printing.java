package makePizza;

import java.util.List;

public class Printing extends Thread{// 프린트 전용 클래스
	List<Ingredient> ingredientList;
	List<List<Food>> orderList;
	int sleep = 50;
	
	public void setSleep(int sleep) {
		this.sleep = sleep;
	}


	public Printing(List<Ingredient> ingredientList, List<List<Food>> orderList) {// 프린트 해야할 리스트들

		this.ingredientList = ingredientList;
		this.orderList = orderList;

	}
	//로고 출력
	public static void printLogo() {
		System.out.println(
				"                                                           \r\n" + 
						" ,----.    ,-----. ,--.   ,--.   ,--. ,-----. ,--. ,--.    \r\n" + 
						"'  .-./   '  .-.  '|  |   |   `.'   |'  .-.  '|  .'   /    \r\n" + 
						"|  | .---.|  | |  ||  |   |  |'.'|  ||  | |  ||  .   '     \r\n" + 
						"'  '--'  |'  '-'  '|  '--.|  |   |  |'  '-'  '|  |\\   \\    \r\n" + 
						" `------'  `-----' `-----'`--'   `--' `-----' `--' '--'    \r\n" + 
						",------. ,--.,-------.,-------.  ,---.                     \r\n" + 
						"|  .--. '|  |`--.   / `--.   /  /  O  \\                    \r\n" + 
						"|  '--' ||  |  /   /    /   /  |  .-.  |                   \r\n" + 
						"|  | --' |  | /   `--. /   `--.|  | |  |                   \r\n" + 
				"`--'     `--'`-------'`-------'`--' `--'      ");
	}

	//메뉴판 출력
	public static void printMenu() {
		System.out.println(
				"                                                           \r\n" + 
						" =======================  메뉴판   ========================= \r\n" + 
						"               오븐피자                                                     화덕피자                       \r\n" + 
						"    1.페페로니           15,000원                           6.페페로니          17,000원          \r\n" + 
						"    2.콤비네이션        16,000원                           7.콤비네이션        18,000원          \r\n" + 
						"    3.포테이토           15,000원                           8.포테이토           17,000원          \r\n" + 
						"    4.불고기              16,000원                           9.불고기             18,000원          \r\n" + 
						"    5.고르곤졸라        13,000원                         10.고르곤졸라        15,000원          \r\n" + 
						"												             \r\n" + 
						"                                       0.핫 윙        7,000원           \r\n" + 
				" ======================================================== ");
	}
	//게임 설명 출력
	public void run() {
		
		String printGameExplain;
		printGameExplain ="=====================  게임설명   =======================>>설명을 skip하시려면 ENTER를 눌러주세요.\n\n당신은 백종원의 골목식당의 수혜자에요 ,\n\n 가게가 망할 뻔 했지만 다시 장사가 잘 되기 시작했어요."
				+ "\n\n메뉴를 피자와 핫윙으로 줄이고 심기일전 하여 가게를 다시 시작하게 됐어요"
				+ "\n\n당신은 주문이 들어오면 주문을 확인하고 '피자' 또는  '핫윙'을 만들어주어야 해요"
				+ "\n\n***재고가 없으면 피자를 만들지 못해요."
				+ "\n\n***피자 토핑 넣는 순서를 틀리거나, 오븐에 잘못 넣을 경우 재료비를 날리고 , 돈을 받지 못해요"
				+ "\n\n음식당 토핑을 입력받는 시간은 10초에요."
				+ "\n\n최대한 신중하게 만들어주셔야 해요"
				+ "\n\n게임이 시작한지 2분이 지나면 백종원님이 불시검문을 오게 돼있어요!"
				+ "\n\n미니게임을 통하여 백종원님의 불시검문을 통과해보세요!  ==>(이기면 +10만원 , 지면 -10만원)"
				+ "\n\n\n기본자금은 10만원으로 시작할거에요. 매출이 30만원이상을 달성하면 게임이 끝나게 돼요."
				+ "\n\n기본자금이 0원이하로 떨어지면 가게가 파산하여 게임이 끝나게 돼요."
				+ "\n\n현재 소유한 자금은 계속 보여드릴거에요~~.\n\n"
				+ "===================================================== ";
		
		try {
			for(int i = 0; i <printGameExplain.length();i++) {
				System.out.print(printGameExplain.charAt(i));
				sleep(sleep);
			}
		}catch(Exception e){
			
		}

	}

	public void setIngredientList(List<Ingredient> ingredientList) { //재료리스트 등록
		this.ingredientList = ingredientList;
	}


	public void setOrderList(List<List<Food>> orderList) { // 주문리스트 등록
		this.orderList = orderList;
	}
	//현재 모든 재료 출력
	public void printIngredientList() {
		for(Ingredient ingredient : ingredientList ) {
			System.out.println(ingredient.getName() + "  --> 현재 남은 수량 : " + ingredient.getNum() );
		}
	}

	//모든 재료 가격 출력
	public void printIngredientPrice() {
		int count = 1;
		for(Ingredient ingredient : ingredientList ) {
			System.out.println(count+"."+ingredient.getName() + "  --> 가격 : " + ingredient.price );
			count++;
		}
	}

	//현재 모든주문내역 출력

	public void printOrderList() {
		if(orderList.isEmpty()) {		  
			System.out.println(">>현재 들어온 주문이 없어요."); 
			System.out.println(); 
		}
		else 
		{
			int count = 1;
			for(List<Food> menuList : orderList) {
				System.out.print(">>"+count+"번째 주문 : ");
				for(Food food : menuList) {
					System.out.print(food.name+" ");
				}
				System.out.println();
				count++;
			}
		}

	}
	public static void printPizza() {
		System.out.println("                                        .--::::-   .::::-.                                          \r\n" + 
				"                                 `::////:-----:o/  s:::://+//:::.`                                  \r\n" + 
				"                              -/+:-..```-:..---:o  o--:::-......-///:.                              \r\n" + 
				"                          .:/+:.....-:+shyyo+/-+/ -hoossyhyo/::-```../+:.                           \r\n" + 
				"                       ./o+:...-/+osyhhhhhs+/ooy. oh+ohysssyso+os/-.``.-/+:`                        \r\n" + 
				"                     `+o:---:osysosyysyyyys+/:om  dy+::--/sssyyyhhdhys/.`./o/                       \r\n" + 
				"                     -o:--/syysysyo/-y+ssyyyssom `Ns/....-//-/+oshhhhhy---.-s:                      \r\n" + 
				"                  `:/:::/+ooyh/:/++--y+ysssyhyhN `Ny:::....-o+sosyhs/+ys--:++``-:.                  \r\n" + 
				"                 -s/-:++/hy+o/.......sooysyyhyyN` Nyosss/.`s+sysssys+./y/+/..-///o+`                \r\n" + 
				"               `++.`---:o+yho/....---.++osyhyssm. Nsosssyo.y/hsssyhoh:ys:.:ss+:---/s.               \r\n" + 
				"              -o-`.-//oo+sssdho-+ssosso/:/oo+/-d: mysyssyh.+syhyyhyyhs:-oyyoooss/---s.              \r\n" + 
				"             /+```syhh+-:/oyyyhhossyysyyo.:/---h+ dsssssys.-oyyyyyhh/:yhs+::shysh+..-s-             \r\n" + 
				"            /+```:mhhh+osssshdyshysssssyy../syoys h/+++o/-./:-/+yh/-shy+-...-:syyd/...o:            \r\n" + 
				"           -o```-ddhhhyyyyyyhyhhyyhysss++`+ssyyyh h/----/ooo+-/ys:ohssss/....+oyys+o..`+:           \r\n" + 
				"           y...+ohyyooossyssyhsy/yyyho::.`yoyssyh hs-:ossssyosy/ohyssssoy.`..//:hyso+```s.          \r\n" + 
				"          :o..-sosd/-y+osyyyyyy+../shdyo/.yyyssyy so.hyyysshho+ssyssssyyo../++o+/hyhh```.y          \r\n" + 
				"          y...ohssy//-/+ooo+o/:+-/yssyddho-oyssyy yo-hyssyhooy+-/+ssyyys-+oooso+ssdhms```s.         \r\n" + 
				"         ++..:dyss+/-..``-++o+/-.:hoyssyhhho:/:+y ys-/syho/yo/...::/+/:.y+syysssyyhhhhs``-s         \r\n" + 
				"         h---osyy+.....-syyyyyys/`s+yyysshhhho-/s s+::so+yo-+sssooo:.://yyhssssyss:ohy:.`.h         \r\n" + 
				"        `y---+osss-...-yoysyssss+-`/oyyyys/+yssd. +ho//sy::yyyyyyysyo-.:yyyyhhyss-.+h::-..h`        \r\n" + 
				"         o+/:+yysssooo+sssosssss-:://////:+:-h:      sd::-+yyssssyyoo/++ohdhhddhsyys/:---:h`        \r\n" + 
				"          `....-:/+ooooooo++ooooossssoooooo+//-       .://+++++osssoossooooossssoo+++////:`         \r\n" + 
				"         so/:/++syysshhhdhhyssssyyhyyhhhhs++oys      hs+yysssssys+++hyyyyssssoooosssss///+o         \r\n" + 
				"        `d-.-::so:-osyyyyyys-.-sysyysysyy+-ooysod.yy+/y:::+sso+/.`//ysssyssss....:syos:---h         \r\n" + 
				"         h.`.:sdo-osyysyshhyo/:-+sssssyy/:ydho-:yoy.+hssyyysyyyoo-.osyyyyyss-`....oyyh/:-/s         \r\n" + 
				"         s-``shhyyyyssssyyoy-.:/::.-:::/shhhyo:-dsy:/:/yyshyssyy+h../oosoo-.`..:++ssyd...y-         \r\n" + 
				"         -o```ydhdysossssoo//sysso+:-:yhhhysyyy`hsdssyy/:ysyhyyysh/-/./++++o+/.//hssh+..-s          \r\n" + 
				"          y```.dhyy++o+oo:.+yysssss+oydhyssyysy.ysmssyhs/-/oyyyyo/--/syyssyso+s::dsos-.`o-          \r\n" + 
				"          :o```ossyy-/:-.`.yoysysshyshssysssso-:yhmssyy+o`-:/yhssy+:sshhssysss+ssyhs+.``y           \r\n" + 
				"           +/`.-s+shso+..`.osssohyoys:-oso+/----ohmsyyos-.oosssyhooshhyhyyyyyyhyhhm:```o:           \r\n" + 
				"            /+..-+hsys-....-+shh+ohs/:-/:.-+o++/osm+syo-.+syssysoyhs+ydyyyyss+yhhmo```/+            \r\n" + 
				"             :o...shyyyo--/ohho+dhyyyys+.-yyssssyyho---/--syyssssyoyhs/syo/:-:hhyh.``/+             \r\n" + 
				"              :o..-osssooshy++ydshhyyhss/:yyssssyhoy-/oso/:/ossooo:-+ydo-oyooso/:.`.+/              \r\n" + 
				"               :s:--:/+yyo::sy:hshyssyy/s.sysssoyd/dsshhyso++......../oyy--o/---.`:o-               \r\n" + 
				"                -o+::/:--/+/y:.osysssyooo`./sss+hm-myhyysshoos..--..-os+sy:`:o/-:+o`                \r\n" + 
				"                  -/:.`++:-:ys//shysos+o-....::/yN.myyhysssy+y.:+o++ohyoo::/-`://-                  \r\n" + 
				"                      +o..--:hhhhhhso+/-//-....+ym`dossyyyys+s-+syysyyyo:--:s-                      \r\n" + 
				"                      `+o:.`./syhdhhyyysss/-:::+yh do://oyyhysyysooy+/---:+o-                       \r\n" + 
				"                        `:+/.```.-/yo+oyssssyho+h+`y+o/+shhhhhhso/:...-/o/-                         \r\n" + 
				"                           ./+:..``.-::/oyhyssooh..s-/+oyyhs/-```..-/+:.                            \r\n" + 
				"                              .:///-......-:::--o :o.--..--```..://:`                               \r\n" + 
				"                                  `.::://+//::::s .y:----:/+//::.                                   \r\n" + 
				"                                          .-::::.  .::::-.`                                         ");		
	}
	
	
	 public static void printHotwing() {
		 System.out.println("                                                                                                    \r\n" + 
		 		"                                                            ````                                    \r\n" + 
		 		"                                                           `````                                    \r\n" + 
		 		"                                                          ``````                                    \r\n" + 
		 		"                                                         ```````                                    \r\n" + 
		 		"                                                       `````````                                    \r\n" + 
		 		"                                                      ````````.                                     \r\n" + 
		 		"                                                    ```````````                                     \r\n" + 
		 		"                                                  ```````````.                                      \r\n" + 
		 		"                                                ````````````.                                       \r\n" + 
		 		"                                               ```` ``````..`                                       \r\n" + 
		 		"                                             ```````````....                                        \r\n" + 
		 		"                                           `.```````......-`                                        \r\n" + 
		 		"                                         `...`````.......--                                         \r\n" + 
		 		"                                       ````.```````....--:`                                         \r\n" + 
		 		"                                    `..```.````.....--:::.                                          \r\n" + 
		 		"                                  `.-.```````......-://:`                                           \r\n" + 
		 		"                `..`            .--..`````````````..//.                                             \r\n" + 
		 		"                :.-:-        `.--..````````.......-::`                                              \r\n" + 
		 		"               .:`..:-    `.--..`````.......-----://`                                               \r\n" + 
		 		"              `/-`..:/`.---.`..`````......-:::::::/.                                                \r\n" + 
		 		"             `:-`.-/+::-......```````.....---::::::                                                 \r\n" + 
		 		"            `:..-:+/:--......````......------::://`                                                 \r\n" + 
		 		"           .:---:+/:--...```````````..----:////:-                                                   \r\n" + 
		 		"         `//--:/+::-.....```...---:::::::/++/`                                                      \r\n" + 
		 		"        -/-.-:/:---.````....```..-----:::://                                                        \r\n" + 
		 		"      `/+-...-..`.................---:/+:.`                                                         \r\n" + 
		 		"     -+//::----..........-----:::::://o-                                                            \r\n" + 
		 		"   `//:::-----........-::::///+++++++:`                                                             \r\n" + 
		 		"   :+/:-``..----------------:::/+ooo-                                                               \r\n" + 
		 		"   .o+/:::---...----...--:::://+/++-                                                                \r\n" + 
		 		"    so++//::--..-----::::///+oo/++//:...-.  ````                                                    \r\n" + 
		 		"   `so++/:::::-----://////++o++///::////////////:.....--..                                          \r\n" + 
		 		"   `so+//------::::://+oooo+/////::::--:://///::::::://////.`                                       \r\n" + 
		 		"    so//---------:::://+o+//::::::::::--://////:::::::::://///////:.                                \r\n" + 
		 		"   `ss+/:::::::://+++ooo+/:----::-..-:---:-://///:::::::::::::::////:.`````                         \r\n" + 
		 		"   `ooo++/://///+soo++////:...----....-:-...---:/:::::::----------::::://+//.                       \r\n" + 
		 		"    .o+++/::::/+oo+////::::::--.....-----::::::::::::::::::::::::::://////+++////::.`               \r\n" + 
		 		"     so/////:::/+++//::-------------------::::::::::::::////:-------::::////////+++o+/`             \r\n" + 
		 		"     oo+/:::/:///////::-------------------------....--:::--:--------:::::::::://++++oo++:-`         \r\n" + 
		 		"     /so+////::::::::::::::--------------------------::---------:::::::::::::::////+++++oo+:`       \r\n" + 
		 		"     `+so+//////::/::::::::::::::::::::------------:::::::-::::::::::::::::////:::///////+ooo:      \r\n" + 
		 		"      `/so++/++++///::::::::::::::/:::::::::::::::::::::::::::::::::::::::::::///////////+ooos+`    \r\n" + 
		 		"        -oooo+ooooo++//////:::::::/::::::::::::::://////////////::::::::::://////////////++oosso.   \r\n" + 
		 		"         `+soosssooo+++++++//::://////:::::://////////+///:::::::::////////////////+++++++ooossss.  \r\n" + 
		 		"           /ssysooooo+++++oo+////+++++/////////:::::::///++++///////++++++++++//////+++++ooossssyy` \r\n" + 
		 		"            -sysooo+++++o+ooo+++++++o+++///:::://////////+++++//////////++oooo+++++++ooooooosssyyh. \r\n" + 
		 		"             .oysssooooosooooooo++++ooooo+++////+++++++++++++++++++//////++ooossssoooooosssssyyyhs  \r\n" + 
		 		"               /yysssoooosssssssooooooossooooo+++ooooooo++++++++ooooo+++++ooooooosssssyyyyyyyyhyo`  \r\n" + 
		 		"                .+yyyysssyyyssysssssssssso+ossooooooosoossooo+++ooosooooooooooosssssyyyyyhhhyy+.    \r\n" + 
		 		"                  ./oyyyyyyyyyyyyssssssoooyyssssyysssyysssssssooooo+oo++syysyyyyyyyyyyyys+/-.       \r\n" + 
		 		"                      .-:/+osyyyyyyyysssyyyyyyyyyyyyyyyyyyyyyysssssosoooooshhhhhhhhyo/-`            \r\n" + 
		 		"                              ``.----::::::---....--:+osyyyyhhhyyyyysyyoshhhhys+:-`                 \r\n" + 
		 		"                                                         .-::/+oooooo++//:-.                        \r\n" + 
		 		"                                                                                                    \r\n" + 
		 		"");
	 }

	 public static void printBeak() {
		 System.out.println("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNmNNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMdoooys:/o:-/oymNNMNNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMd//-``. `.--.-./ys:+sosyymMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMy/`.`  `...```.`...`  ```..-+NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMNy:.`   ````.`     ```.`  ``.```-+yNNNMdNMMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMMMMMMMMds/.```    ``  `     ``` ``   `.`   ``../hhNNMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMMMMMNy-``` ```   ``.```    ..`` ` ` ````   .   `/ydhMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMMMMMo-```..```   `..`` ``  ```` `   ````````    ``..hMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMMMN+.`.``--.``   ``..`....``-..`     `````...`   `..+MMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMMmo.`.`  ``.`  `.-::-`./++++o+o+::-..````  ``````  -hNNMNMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMd--..`  `  ` `----..-/oyhhdmmmmmmddhhyso+:.`   `..``.-oodMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMm-`.`   `    `://++++oyhdmmmNNNNNNNmmmmmmdhy+:`      ````mMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMM/```       .:/+oossyhdddmmNNNNNNNNNNNNmmmmddhy+-``     `-MMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMN-``  ` ``.:+oosyyhhddddmmNNNNNNNNNNNNNNmmmdddhho:`      .NMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMN-`    `.-:+osssyyhhdddmmmNNNNNNNNNNNNNNmmmdddhhyo-`      mMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMM+``````.-/+syyyhhhdddmmmmNNNMNNNNNMNNNNNmmmdddhhy+-`     sMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMh``````.:+ossyhhsssssssyhmNNMMMMNMMMNNNNmmdmdddhhs:``    .MMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMy `````.:/+ssys/-:::::://+sdmNNNMMNNmdyo+//+++ohhy/.    `-MMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMo  ````.:/+sos+++shddmmmddhddmmNNNmmhysssso+/::yhy+``   `sMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMo   ```./++oososyhddmmNNNmmdddmNNmdddmmNNNmmdhsshy/````+hMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMh`` ```.osssys+oso+/://ooyhdhdmNNmhdddhhddddddhhyy/```+MMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMM+.````.oyhhhyoooosyhdddyhddhhmNNdddhssosoooshhhhy/``.NMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMM/..```-+yhdddddddddddmmmmmdhdmNmddmmddddddhyhhhhy/`.hMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMo:-.`-:+hddddmmNNNNNNNNmmddhdmNNmmmmmNNNNNmmmmddy/`:MMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMs+:./so+shdddmmNNNNNNNNmddhdmNNNmmddmNNNNNNNNmddh+:hMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMss+-+so+syhhdmmNNNNmmmdhddddmNNNmmmmdddmNMNNNmmdhyhmMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMhyo/:+++osyhdmmmmdhdmmyoyo/:+yyyo+ohmmdyhmNNmmdhymmNMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMmhss/+/o+osyhdddyhddddddddddyyhhhdhdmmmdssdmmddyymmNMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMMmyso//+oosyhddhhhhhddddddmNNNNNmmmmmmmmdosdddhyydmNMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMMMmho::/+ssshdmmmdo/:/+oosyhdddhhhysssyhddymddhyymmMMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMMMMMN//:/ossyhmNmmmyo+oyyddmNmNNmmdy::sdmmmmmdhyhNMMMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMMMMMMs/::/syyyhmmmmmmdhhyhdmNmmmmdhhhmmmmmmmdhhyNMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMMMMMMh/:-:+shhyydmmmmmdddddmmmmmmdhdmmmmmmdhhhymMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMMMMMMd::::/+syhyshddmmmmmmmmmmmmmddmmNmmmdhhysmMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMMMMMMN:-:::/+osyooyhmmmmmNNNNNNNNNNmmmmmhhhysmMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMMMMMMM/----:::/+o+oshdmmmmNNNNNNNmmmmmdyyysoyMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMMMMMMM+-------:::///+shdmmmNNNNNNmmmdysso+++dMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMMMMMNd+/::::----::://:/oyhdddddhhhhsoo++/+ooNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMMMNy/:o//////:::::::///:://////++++++oooossyMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMMNdo-.+++++++//:::://///+++ooooooooossssyhydNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMNNd/`-:+ossoo++//::///++++ooooooosssssyhdhysMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMNNMNo:--/osyhysso+////++oooooosssyyysyhdddhy:NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMNmNMMh/-/oyhhhhhysoooooossssssyyhhhhhdmmmddy/MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMNNMMNmNMMMm++oyhhdddddhyyyyhhhhhhhddddddmmmmmmdhNMNNMNNNMMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMNMMMMmNNNMMMdyyhhdddddddhhhddmmmmmmmmmmmmNNNmmNMMMNNMMMNMMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMmNNNNNMMMmdddmmmmmmddddmmmmNmmmmmmNNNNmNNNMMNNNMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMNNNNNNNNNMMNNmmmmmmmddddmNNNNmmmmNNNNmNm+-oNMNMMNMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMNNNMMNNNNNNNMMMMmdmmNNNNmmddddmmmmmmNNNNNmmdo-`-dNMNMMMMMMNMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMNNNNMMMMMMMMNMMMMNhyyyhmmNNNNNmmddmmmNNNNNmmmNmdys+-oNMMMMMMMMNNMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMNMMMMNhdmNNmhddddmNNmmmNNNNNNNNNNNNNNNNMMMMMMmh++NMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMMMMMMMMMMNyoyyhmNMMMNmddmmmmmNMMNNNNNmNMMMMMMMMMMMMMNhohNMMNMMMMMMMMMMMMMMMMMMMMMMMMM\r\n" + 
		 		"MMMMMMMMMMMMMMMNNNMMMMMMhoyssyhdmNMMMMMMMMMMMMMMNNNmmMMMNMMMMMMMMMMMMMdymNMNNNNMMMMMMMMMMMMMMMMMMMMM");
		 
	 }
	 
	 public static void printFail() {
		 System.out.println("\r\n" + 
		 		"                                                                                                     \r\n" + 
		 		"                                                                                                    \r\n" + 
		 		"                                                                                                    \r\n" + 
		 		"                                               ``````                                               \r\n" + 
		 		"                                         `-+shdmmmmdddhs+:`                                         \r\n" + 
		 		"                                      `/ymmNNNmmmmmmmmNNNmmy/`                                      \r\n" + 
		 		"                                    .odNNNNNmmmmmmmNNNNNNNNNNdo.                                    \r\n" + 
		 		"                                  `omNNNNNNNmmNNNNNNNNNNNNNNNNNmo.                                  \r\n" + 
		 		"                                 `hNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNd:                                 \r\n" + 
		 		"                                 sNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNd`                                \r\n" + 
		 		"                                `mNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN-                                \r\n" + 
		 		"                                :NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN+                                \r\n" + 
		 		"                                +NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN+                                \r\n" + 
		 		"                                +NNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNNN+                                \r\n" + 
		 		"                                /NNNNNNNNNmmNNNNNNNNNNNNNmNNNNNNNNN:                                \r\n" + 
		 		"                                `mNNNms++/--/ymNNNNNmmh+:-:++sdNNNm`                                \r\n" + 
		 		"                                 oNNm-        -dNmmmm:`       .hNNy                                 \r\n" + 
		 		"                                 .dNy          ymmmmd`         oNm-                                 \r\n" + 
		 		"                                 smNm        `+mmssmNs`        yNmy                                 \r\n" + 
		 		"                                 sNNNo.` ``./yNd:  -dNh+-`` ``/mNNs                                 \r\n" + 
		 		"                                 `ymNNmhyhdNNNN:    -NNNNdhyhdNNNy`                                 \r\n" + 
		 		"                       `:-`        /hmmmmmNNNNN`    `NNNNNNmNNmd/        `-:`                       \r\n" + 
		 		"                      :mNNmy:        .---:hNNNNhoyyoyNNNNd/://-        :ymNNm:                      \r\n" + 
		 		"                     .dNNNNNN/            oNNNNNNNNNNNNNNs            /NNNNNNd.                     \r\n" + 
		 		"                   .hNNNNNNNNNh-          :dNNNNNNNNNNNNm/          -hNNNNNNNNNh.                   \r\n" + 
		 		"                   oNNNNNNNNNNNNh/          sNNNNNNNNNNs`         /hNNNNNNNNNNNNo                   \r\n" + 
		 		"                   `dNNNNNNNNNNNNNmo-        .+oooo++:.        -omNNNNNNNNNNNNNd`                   \r\n" + 
		 		"                    `ohdhhhhdmNNNNNNmdo-                    -odmNNNNNNmdhhhhdho`                    \r\n" + 
		 		"                            ``-+ymNNNNNmdo-`            `-odmNNNNNmy+-``                            \r\n" + 
		 		"                                 `-ohmNNNNmds:.      .:sdmNNNNmho-`                                 \r\n" + 
		 		"                                    ``:ohmNNmmmy+--+hmmNNNmho:``                                    \r\n" + 
		 		"                                        `.+ydmNNNmmNNNNmy+.`                                        \r\n" + 
		 		"                                           -omNNNNNNNNmo-                                           \r\n" + 
		 		"                                       `:ohmNNNNNhhNNNNNmho:`                                       \r\n" + 
		 		"                                   `-+ydmNNNNmho-``-ohmNNNNmdy+-`                                   \r\n" + 
		 		"                               `-+ydmNNNNNmho-`      `-ohmNNNNNmdy+-`                               \r\n" + 
		 		"                     .---:::/oydmNNNNNNmh+-`            `-+hmNNNNNNmdyo/:::---.                     \r\n" + 
		 		"                    /dmmmNNNNNNNNNNNmh+-`                  `-+hmNNNNNNNNNNNmmmd/                    \r\n" + 
		 		"                   /mNNNNNNNNNNNNmho-`                        `-ohmNNNNNNNNNNNNm/                   \r\n" + 
		 		"                   `/sdNNNNNNNNmy:`                              `:ymNNNNNNNNds/`                   \r\n" + 
		 		"                      :NNNNNNmy:`                                  `:ymNNNNNN:                      \r\n" + 
		 		"                      `ydmmmh:                                        :hmmmdy`                      \r\n" + 
		 		"                        .--.                                            .--.`                       ");
	 }
	 
	 public static void printFoot2() {
		 System.out.println(
				"                                                  \r\n" + 
		 		"                                                                    `-+ydmdyo-                      \r\n" + 
		 		"                                                                  `/dNMMMMMMMNh:                    \r\n" + 
		 		"                                                                 :dMMMMMMMMMMMMNo                   \r\n" + 
		 		"                                                                oNMMMMMMMMMMMMMMMo                  \r\n" + 
		 		"                                                               sMMMMMMMMMMMMMMMMMM/                 \r\n" + 
		 		"                                                              oMMMMMMMMMMMMMMMMMMMm`                \r\n" + 
		 		"                                                             -NMMMMMMMMMMMMMMMMMMMM+                \r\n" + 
		 		"                                                             hMMMMMMMMMMMMMMMMMMMMMm                \r\n" + 
		 		"                                                            -MMMMMMMMMMMMMMMMMMMMMMM.               \r\n" + 
		 		"                                                            oMMNNMMMMMMMMMMMMMMMMMMM/               \r\n" + 
		 		"                                                            hNMmmNNNMMMMMMMMMMMMMMMM+               \r\n" + 
		 		"                                                            NNMMNNNMMMMMMMMMMMMMMMMMo               \r\n" + 
		 		"                                                            MMMMNMMMMMMMMMMMMMMMMMMM+               \r\n" + 
		 		"                                                            NMMMMMMMMMMMMMMMMMMMMMMM:               \r\n" + 
		 		"                                                            hMMMMMMMMMMMMMMMMMMMMMMM                \r\n" + 
		 		"                                                            sMMMMMMMMMMMMMMMMMMMMMMy                \r\n" + 
		 		"                                                            -MMMMMMMMMMMMMMMMMMMMMM-                \r\n" + 
		 		"                                                            `mMMMMMMMMMMMMMMMMMMMMs                 \r\n" + 
		 		"                                                             /MMMMMMMMMMMMMMMMMMMh`                 \r\n" + 
		 		"                                                              :ydmMMMMMMMMMMMMMMd`                  \r\n" + 
		 		"                                                                 ``:+shmMMMMMMMy`                   \r\n" + 
		 		"                                                                       `.:+syo-                     \r\n" + 
		 		"                                                                                                    \r\n" + 
		 		"                                                                                                    \r\n" + 
		 		"                                                                                                    \r\n" + 
		 		"                                                           :++:-.`                                  \r\n" + 
		 		"                                                          -mNNNNNmdyo/-.                            \r\n" + 
		 		"                                                         `dMMMMMMMMMMMNNds`                         \r\n" + 
		 		"                                                         oMMMMMMMMMMMMMMMN.                         \r\n" + 
		 		"                                                        `NMMMMMMMMMMMMMMMs                          \r\n" + 
		 		"                                                        /MMMMMMMMMMMMMMMm.                          \r\n" + 
		 		"                                                        +MMMMMMMMMMMMMMM/                           \r\n" + 
		 		"                                                        .NMMMMMMMMMMMMN+                            \r\n" + 
		 		"                                                         -hNMMMMMMMMNh-                             \r\n" + 
		 		"                                                           -+shmmdy+-                               ");
	 }
	 
	 public static void printFoot1() {
		 System.out.println("                                      \r\n" + 
		 		"                      -oydmdy+-`                  \r\n" + 
		 		"                    :hNMMMMMMMNd/`                \r\n" + 
		 		"                   oNMMMMMMMMMMMMd:               \r\n" + 
		 		"                  oMMMMMMMMMMMMMMMNo              \r\n" + 
		 		"                 /NMMMMMMMMMMMMMMMMMs             \r\n" + 
		 		"                `mMMMMMMMMMMMMMMMMMMMo            \r\n" + 
		 		"                +MMMMMMMMMMMMMMMMMMMMN-           \r\n" + 
		 		"                mMMMMMMMMMMMMMMMMMMMMMh           \r\n" + 
		 		"               .MMMMMMMMMMMMMMMMMMMMMMN-          \r\n" + 
		 		"               +MMMMMMMMMMMMMMMMMMMMNNNo          \r\n" + 
		 		"               +MMMMMMMMMMMMMMMMMMMNNNMh          \r\n" + 
		 		"               oMMMMMMMMMMMMMMMMMMNNMMMN          \r\n" + 
		 		"               +MMMMMMMMMMMMMMMMNMMMMMMM          \r\n" + 
		 		"               :MMMMMMMMMMMMMMMMMMMMMMMN          \r\n" + 
		 		"                MMMMMMMMMMMMMMMMMMMMMMMh          \r\n" + 
		 		"                yMMMMMMMMMMMMMMMMMMMMMMs          \r\n" + 
		 		"                -MMMMMMMMMMMMMMMMMMMMMM-          \r\n" + 
		 		"                 sMMMMMMMMMMMMMMMMMMMMd`          \r\n" + 
		 		"                 `hMMMMMMMMMMMMMMMMMMM/           \r\n" + 
		 		"                  `dMMMMMMMMMMMMMMmdy:            \r\n" + 
		 		"                   `yMMMMMMNmhs+:``               \r\n" + 
		 		"                     -oys+:.`                     \r\n" + 
		 		"                                                  \r\n" + 
		 		"                                                  \r\n" + 
		 		"                                                  \r\n" + 
		 		"                                  `.-:/+:         \r\n" + 
		 		"                            .-/oydmmNNMMN-        \r\n" + 
		 		"                         `sdNNMMMMMMMMMMMd`       \r\n" + 
		 		"                         .NMMMMMMMMMMMMMMMo       \r\n" + 
		 		"                          sMMMMMMMMMMMMMMMN`      \r\n" + 
		 		"                          .mMMMMMMMMMMMMMMM/      \r\n" + 
		 		"                           /MMMMMMMMMMMMMMM+      \r\n" + 
		 		"                            +NMMMMMMMMMMMMN.      \r\n" + 
		 		"                             -hNMMMMMMMMNh-       \r\n" + 
		 		"                               -+ydmmhs+-         ");
	 }
	 public static void clearScreen() {
		    for (int i = 0; i < 80; i++)
		    	if(i>=60&&i<65) {
		    		System.out.println(" Enter를  연속으로 눌러주세요!!");
		    	}else {
		    		System.out.println();	
		    	}
		  }
	 
	 public static void printMoney() {
		 System.out.println("                                                          .-::://.                                  \r\n" + 
		 		"                                          `---------....`:///////`                                  \r\n" + 
		 		"                                       `-::://///++/:-:/:/o+++++:.                                  \r\n" + 
		 		"                                      -/++/:////+oo/:://::ssooo/-:-.                                \r\n" + 
		 		"                               `.``.-://+++//+//+oo/:://:sysoo/::::::.                              \r\n" + 
		 		"                           `  .//:::///++oo+:/+++oo///+//hyoo+::////:.                              \r\n" + 
		 		"                         `::-.:/+++/:/+++ooo//+++oo+//+:shyo+::///:-`                               \r\n" + 
		 		"                          .-::::/++++//++oooo/+++oo+/+//hyso:://:-`                                 \r\n" + 
		 		"                             ``.-:/+oo++++osso/++oo+++/shyo////.                                    \r\n" + 
		 		"                                  `.:+osooooyy+++oo+o+ohys///.                                      \r\n" + 
		 		"                                     `-+yyyysyyossyoooddyo+-                                        \r\n" + 
		 		"                                       /ymmmddmdddddhdmdhho-                                        \r\n" + 
		 		"                                      -dmNNNmNNmNNNNNmNNNNNo                                        \r\n" + 
		 		"                                      -dhhhhdmmNNNNNddmNNNd:                                        \r\n" + 
		 		"                                       :+yhhyyyyyhhs/:/ddhs-                                        \r\n" + 
		 		"                                       .:+ssoosyyyyyso//sso+:.                                      \r\n" + 
		 		"                                     `.-:/:---:+osyyyyhhyyyyso/.                                    \r\n" + 
		 		"                                   `.--:::....-::///:::/osssyhhhyyss`                               \r\n" + 
		 		"                                  `.--::-..`..---:::-----://+osyyhh/                                \r\n" + 
		 		"                                `..-----..``..----:-----..----/ssso/.                               \r\n" + 
		 		"                               `..-----.```....---::-:--..----.-/++/:-`                             \r\n" + 
		 		"                              `.-----..````..-.---:::::--.------.-///:-`                            \r\n" + 
		 		"                            ``.-----..`````..-..--:::::------:::-..-:::-`                           \r\n" + 
		 		"                           `..-----..`````..--...--::::-----:::::-.`.----`                          \r\n" + 
		 		"                         ``...---...`````..----...--:::------::/:::.`.---.`                         \r\n" + 
		 		"                        ``....-...`````...--::------:/:--.---:://:::.``.--.                         \r\n" + 
		 		"                       ``........````....-::::-oyy/-ddh:-----::::/::-.``...`                        \r\n" + 
		 		"                      ``........````....--::++ohddhhdmms+os/--:::::::-.``...`                       \r\n" + 
		 		"                     ``.........``....--::+ydmddddyoddmddhhs---::::::-..``...                       \r\n" + 
		 		"                    ```.............----:ommmm+yddo:dmd+shhy.--:-::::--...`..`                      \r\n" + 
		 		"                   ```.............----::dNNNd/ymmo-dmd:-shy----::-:----...`..`                     \r\n" + 
		 		"                   ``............----::::smmNNhdmmo:mmm:--:-----:::-:---......`                     \r\n" + 
		 		"                  ```.......-.-.-----::::/sdmNNmmmdhdmmo+/:-:---:::::----......`                    \r\n" + 
		 		"                  ``......--..-----:::::////oyhdNmmmmmmmmdyo/::::::::-----.....`                    \r\n" + 
		 		"                  `....---.---------:::///////:hNNy+mdmdmmdmdo::/::::-:---......`                   \r\n" + 
		 		"                  `.....--..------:-:::///hhs//hNNs:mmm/odmmmm//:::-:-:----.....`                   \r\n" + 
		 		"                 ``....-.--------:::::://+mmm+/hNNs:mmm//ymmmm/::::::-:----.....``                  \r\n" + 
		 		"                 ``...---------:-:::/:://omNmdshNNs:mmm/omNNms:::/:::-:---.-.....`                  \r\n" + 
		 		"                 ``.-.------:--/--::/:/:/ymddmNmNNdymmmdmmmho///:::::-:-----......`                 \r\n" + 
		 		"                 `..--.--------::-::/:///+o+/+odNNddNmmyso/////:/::::-:----.......`                 \r\n" + 
		 		"                 `...-------::-:::::///////////sdmo:hdd////////::::::-:-----.......`                \r\n" + 
		 		"                 ``..---::--::-:::://///////////////::::////////:::::-:-----........                \r\n" + 
		 		"                 ``..---::-:::-///://///////////////::::////////:::::::------.-----.`               \r\n" + 
		 		"                 `...--:::-:::::/::///://///////////::://///////:/::::::------------`               \r\n" + 
		 		"                 .....----::::::::////////////://///::://///////:::::::::-----------.               \r\n" + 
		 		"                 .--..---::::::/:://////////////////:://///////:::::::::::--::::::--.               \r\n" + 
		 		"                 .-::-.--::::://///://:///////////////////+/////:::::::::::::::::::-.               \r\n" + 
		 		"                 `-////:--::::////////////////////////+++++//////////////////////:-`                \r\n" + 
		 		"                 `.:+syys+/////////////////////////++++ooo++++////+++++++ooossys+:.`                \r\n" + 
		 		"                 ``.-:/osyhhhyssoo++++++++++++++++++oossssssoosssyyhhhhyyso+/:-.``                  \r\n" + 
		 		"                   ````.--:/+osyyhhhhhhyyyyyyyyyyyyyyyyyssssssoo++/::-..````                        \r\n" + 
		 		"                           `````````..............``````````````                                    ");
	 }
	 
	 public static void printMiniGame() {
		 String minigame = "\n\n=====================  미니게임  백종원을 이겨라!   ======================="
		 		+ "\n\n백종원님께서 당신이 잘 하고 있나 불시검문을 왔어요!"
		 		+ "\n\n백종원님한테서  들어오는 압박을 잘 버텨보세요 "
		 		+ "\n\n백종원님이 지속적으로 압박을 가하면 게이지바가 줄어들거에요"
		 		+ "\n\nENTER를 연속으로 눌러 게이지바가 0으로 줄어들지 않게 잘 버텨보세요!"
		 		+ "\n\n**이기면 상금 10만원"
		 		+ "\n\n**지면 벌금 -10만원이에요"
		 		+ "\n\n게임을 시작하려면 ENTER를 눌러주세요"
		 		+ "\n\n================================================================= ";
		 for(int i = 0 ; i <minigame.length(); i++) {
			 System.out.print(minigame.charAt(i));
			 try {
				sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 }
		 System.out.println();
		 System.out.println();
	 }
	 
	 public static void printGood() {
		 System.out.println("/ohdsydddhs+/hMMMMMMMMMMMMMMMMMMMMMMMMMMN+-`.-/::/+oossoosss+::o/:--....-..//:+++:-.`````````    `-:\r\n" + 
		 		"yo/ohmmmddhhhyNNNMMMMMMMMMMMMMMMMMMMMMMMNd-`.:+shdmNNMNhhhyo///+oso-....```//:/++-`      `.`     ``.\r\n" + 
		 		"/+yyo+hmmds+oohMMMMMMMMMMMMMMMMMMMMMMMMMm/o.`/osyhdmdhysyooo++ohddN+....``.//:+o-`       `.`     `::\r\n" + 
		 		"oo+/oyo+ydh+/:/mMMMMMMMMMMMMMMMMMMMMMMMMNy/::-:/:-.-.``:+oo+//////:-......`+//:.        `..```   ``.\r\n" + 
		 		"`.:oo/+so:/shssdNmmMMMMMMMMMMMMMMMMMMMMNo..`   `` `      ./+++/oo+/--...``.+:.``        `--.``   ./+\r\n" + 
		 		"`   .:/-. -o+oo+-//sMMMMNMMMMMMMMMMMMMm-`.``   `           `--.::.`````  ..:``        ```//```   `.:\r\n" + 
		 		"`        -.-..`  `:smMMNsmMMMMMMMMMMMy``` `     ``           `shhd+..```//.```       `..-ys.``  `/o/\r\n" + 
		 		"` `     :.        `:+ommhsMMMMMMMMMMy    ``-+o:````           -yso/-....`   ./``  ``..-:+md-``  `./y\r\n" + 
		 		"`     :s:        `   .dmmymMMMMMMMMM:  `-/shdmhs/::.           ohd:``.:    `.o-- `..-:+/oNN:``  .yyy\r\n" + 
		 		"`    :/  `.`    .``.` /dhyhMMMMMMMMM: `/syhdmmmmdhhy+////.`    /NNs-../   `--s:/`.---:osyNN:..   -sm\r\n" + 
		 		"`    ` ````      `...``+dNdMMMMMMMMM- :yhhyyhmmmmho++/:ohho-   .NNN:.`:`  `..y//`-:://ooydh-..  .sys\r\n" + 
		 		"`   -.         `` ```` -ydNMMMMMMMMN: /y++syyydddyhmmmddddho   /Nmd/.:o.   `.s/+`-://oo+/++-..  `:ym\r\n" + 
		 		"`   /`            .:/:-.yNMMMMMMMMMNh`+shsoossymhsooosyddddh. -dNdy/.o+     .y++.::::+so+o+:-.  -sso\r\n" + 
		 		"`  `o              /smhddoyNMMMMMMMMMhohooshhdmNmdddddmmmddh++shNy-:.sy.   `.s++.::::+sooo+:-.  `:yd\r\n" + 
		 		"`  ./              -::hddddMMMMMMMMMMMymNNNNmdNNmmddmNNmmmdhhsdmN+-:.oy.    .y++.:::/oo/:oo...  ./oo\r\n" + 
		 		"`  .`           ``   .+sdshNMMMMMMMMMMmdmmdsysosoosy+ohdddddhmmNN-::.`+.    -y++.:::::::/ss...  `-+y\r\n" + 
		 		"`               ``.``  --/hNNNMMMMMMMMmyyo+yhysshddddy+hdddhddNMm/yys./.    -s++.-----::/oo...  `-:+\r\n" + 
		 		"`               `  ````  /dmNMMMMMMMMMNyyyho//osys+/odmdddhhh+mMmhMMMy:`    -s++.-------:so...  `.:o\r\n" + 
		 		"`                   `-o.`+hdmmNMMMMMMMMdohmmhhhhhddmNmdyyyyyyshMmhMMN/:`    -s//.----:::/so---  `-:+\r\n" + 
		 		"`                 `  -/ `shdmNNNMMMMMMMMy/sdmmdddmmmmhyso++ss+.:syNh/`-`    -o//`.------:yo---  `-/s\r\n" + 
		 		"`        `    `      `.`.oyhddmNNMMMMMMMMh-:shddddhyo+/:-:/:. ``.oh:..o-    -o/:`..-----/ho-:-  `-:/\r\n" + 
		 		"`.`     `.`   `     `.-.-sshddmNMMMMMMMMMN/.`.-:--..-.-:-.` ``````--` -.    -o/:`..---::+yo:::  ./oh\r\n" + 
		 		"`:.`    `-``  `  ```..:-:hddddmNMMMMMMMMMm/:.````````.``.` `````````..-.    -o//`.---:::/hs://  `:/+\r\n" + 
		 		"`-/+`   `:``  `  ```../-:dNNNNmdMMMMMMMMo` .`````   `.-.``````````````..`   -o+/`.-----:+hs:// `.oyd\r\n" + 
		 		"`-:/.   .:`  ``  `````...-omd+ohMMMMMMd:`  .-.....-::-``````````````````.-.`:o+/..--::::ohs/// ``:oo\r\n" + 
		 		".:. ``  ./`  ```..--:/::/.oNy+odMMmhs/.`   :-......`````````````` ``````...-:/+/..-::///+ds/// `:mmm\r\n" + 
		 		".-.`    -/`  ```.-://++//-dNhhyo/:::-``  `/+/:--:::````````````  ````````````..---:::::/ody/+/ `./os\r\n" + 
		 		".`-:` ``-+`  ```-//+o+so+oNMMm:.-:-.``   /yyysooo:``  ```````` `````````````````.--:::/+hds/o/ .:dmm\r\n" + 
		 		".`::` ``:o` ```.-+/+soyssyNMd-...`````   syyhhhy-```    ````` ``````````````````````-:/omms+o/ `./+o\r\n" + 
		 		"-`+/. ``:o` ```.:o+ossysshNs``````````` .yhhhh/`````/.       ````````````````````````.:mmmsoo: .:dmm\r\n" + 
		 		"-`//. `.:o` ``.-/oossssssho```````````` :yhho.`````-mm/`    ````````````````````` ````.hhmsoo: `-+ss\r\n" + 
		 		"-`s+.```:o. `:-.+ssyyyyyyN.```````````` +hs:````````omNm-`````````````````` ```    ````-ydsoo- `:mNN\r\n" + 
		 		"-`yy+:::+s. .o/.:osssyhyy/ ```````````` o/..````     hmmh````````````````   ``      ````+dooo:`.-/ss\r\n" + 
		 		"-.:+oosyys. .s+.:oossyss+  `````````````.`   `/oo/...smNNs``````````  `            `````.hooo: `-odm\r\n" + 
		 		"-.ssdyyyys. .s/./+ooooso:     ````````       smNNMMMNNNNNm.``````````                ````/oos:`.-+++\r\n" + 
		 		":``-dyyyys. .o/.:+ooooss- `    `````        .yhhdmNNmNNNm:```````            `  `    ````.+ss- `./yh\r\n" + 
		 		"-`  -yyyys. -o:.:oooosss` ``    ```         -ydNNNmmmmmd: ````````            ````````````/sy:`.-/++\r\n" + 
		 		"-`.:osyyys. :o:./oosoyss ```      `         .sssymddddh-  `` ``````           ````` ``````-+y: `.:oy\r\n" + 
		 		".`-/osysss. /o/-/oosyoy: ```                `ohddhhhhs`         ````          `` `````````.+y-`..:::\r\n" + 
		 		".`-/osssss.`/o:.:oooyos````                  oyhhyys/               ````      ``````   ````+y- `.-/o\r\n" + 
		 		".`-+osssso.`/o-.:ossss: ```                  `-/sys:                  ````           ```` `-y-`.---:\r\n" + 
		 		".`./+sssso.`+o-.-/+o+o` ```        `            `                     `` `````           ```s.``..:+\r\n" + 
		 		".`.-/soooo.`++-.:ooo+:  ``                                                 ````````    `````:.`..::-\r\n" + 
		 		".`..:oooo+.`/+..-+oo+`                                                       `  ```````   ``````..-:\r\n" + 
		 		".`..:ooo++.`++../ooo:                                                               `````   `.`..---\r\n" + 
		 		".`..-+o+++.`//..-:::`                                                                        ``...-:\r\n" + 
		 		"");
	 }
}
