package com.example.demo.utils;

import com.example.demo.utils.Model;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class StockUtils {


    ExecutorService threadPoolExecutor =  Executors.newFixedThreadPool(50);
    Model model = new Model();
    public int min = 500;
    public String params="d=2006-09-16";
    public String stockNum="上海601939,上海601857,上海601288,上海601318,上海601988,上海600519,上海601328,上海600036,上海600028,上海601628,上海601088,上海600900,上海600104,上海601166,上海600016,上海600000,上海601601,深圳000333,上海601998,深圳000002,深圳000651,深圳000858,上海601138,上海601766,深圳002415,上海601668,上海600276,上海603288,上海601818,上海600585,深圳000001,深圳002352,上海600030,深圳002304,上海601800,上海601390,上海600019,深圳300750,上海600050,上海600887,上海601360,上海601186,上海601336,深圳001979,上海600048,深圳300498,上海601229,深圳002594,上海601169,上海601211,上海600018,上海601006,上海601688,深圳002024,深圳002027,上海601888,上海600009,上海600015,上海601111,深圳200725,深圳000725,上海601238,上海601989,深圳000166,上海600011,深圳000617,深圳002142,上海600309,上海600837,上海601985,上海603259,上海601225,上海600690,深圳000895,深圳000776,上海600406,上海601669,上海603993,上海601899,上海600999,深圳000538,上海600518,上海601933,上海600919,上海600196,上海601727,上海600346,上海600010,上海600606,深圳300015,深圳002475,深圳000063,上海600023,上海600340,上海600029,深圳000568,上海601618,上海600115,上海601009,深圳000338,深圳300122,深圳002739,上海600031,深圳300059,深圳002450,深圳002493,上海600741,上海600660,深圳002736,上海601898,深圳000963,上海600703,深圳002120,上海600958,上海600332,上海600688,上海600547,深圳300003,上海601155,上海601881,深圳002714,上海600893,上海600436,上海601607,上海601633,上海601600,深圳000938,上海601066,上海601018,深圳001965,上海600886,上海601991,深圳002602,上海600588,上海600760,上海600485,上海600271,上海600188,上海600795,深圳000069,深圳002230,上海600377,上海601877,深圳000898,深圳002044,上海600025,深圳002032,上海600600,上海600398,上海601808,深圳000768,上海601901,上海600085,深圳002075,上海600926,深圳300124,上海600663,上海900932,深圳002558,上海600297,上海600705,上海600362,上海601012,上海601788,深圳002008,上海600383,上海600487,深圳002841,上海600482,深圳002236,上海600027,上海600674,上海603156,上海601828,深圳000540,上海603160,深圳002422,上海600111,深圳002456,上海601919,上海600236,深圳300408,上海600516,深圳002466,深圳002007,深圳200596,深圳000596,深圳000629,上海600176,深圳002153,深圳000100,上海600809,上海600299,上海603260,上海603833,深圳000709,深圳000703,深圳002311,深圳002411,上海600808,深圳300413,上海600221,上海900945,深圳002179,上海601992,深圳002146,深圳002202,深圳300433,深圳300144,上海600566,上海600256,上海600535,上海600871,深圳000661,上海600570,上海600498,深圳300454,上海601021,上海600637,深圳002001,上海601838,深圳002010,上海600061,上海600867,深圳002624,上海603799,上海600233,深圳002460,上海600068,上海601118,上海601117,上海600352,深圳002410,上海603019,上海601228,深圳002013,深圳002468,深圳000825,深圳300146,深圳000656,深圳002601,深圳002147,上海601377,上海603589,上海600998,深圳200418,深圳000418,上海600066,上海600339,深圳000627,深圳200625,深圳000625,深圳000423,深圳002110,深圳002294,上海600100,深圳000425,上海600426,深圳300072,深圳002563,上海600675,深圳000046,上海600583,上海600170,上海601997,深圳002773,上海600390,上海600177,深圳002608,上海600801,上海900933,深圳002673,上海600489,上海603899,上海600208,上海601108,上海601158,深圳300186,上海600089,深圳000977,深圳000413,深圳200413,深圳002506,深圳002050,上海600655,深圳000876,深圳300070,深圳000157,深圳000039,深圳300136,深圳000786,上海601216,上海600219,深圳000783,上海601699,上海601198,上海600816,上海601233,上海600872,深圳200553,深圳000553,上海600298,深圳300601,上海600372,上海600004,深圳002399,深圳002241,深圳002180,深圳000860,深圳000883,上海600673,深圳000981,上海603866,上海603858,深圳000932,深圳000415,上海603369,上海600642,深圳000408,深圳300142,上海600522,深圳002408,上海603658,上海601872,深圳002065,深圳002555,深圳300347,深圳300024,深圳002310,上海601212,深圳000999,深圳000050,深圳300253,上海600038,深圳000301,上海601333,上海600438,上海600528,深圳000671,深圳000630,上海600157,上海600497,上海603885,上海600699,深圳300450,上海600977,深圳002081,深圳000959,上海600350,上海603228,深圳000792,上海600153,深圳300676,上海601098,上海603986,深圳300251,上海601878,上海900934,上海600754,上海600183,上海600578,上海600903,深圳002916,深圳002405,上海601231,上海600875,深圳000983,深圳300296,深圳000027,上海601866,上海600745,上海601990,上海600515,深圳000728,深圳002926,上海601003,上海600967,深圳000961,上海600415,上海603056,深圳002508,深圳002353,深圳300308,上海601880,上海601958,深圳300741,上海603868,深圳300383,深圳002371,深圳002299,深圳200539,深圳000539,深圳300628,深圳000513,上海600782,上海600201,上海603816,上海600118,上海601869,深圳300017,深圳002049,上海603659,上海600704,上海601106,上海603515,深圳000813,上海600985,上海600511,上海600109,深圳000402,深圳002465,上海600270,上海900909,上海600623,深圳300133,深圳000778,深圳300033,上海600160,上海600549,深圳002745,深圳002038,上海600161,上海600022,深圳002470,深圳002831,深圳002271,深圳002372,上海600026,深圳002812,深圳000732,深圳300747,深圳002507,深圳002439,深圳002384,深圳002195,上海600848,上海900928,上海603939,深圳000830,深圳300529,深圳000028,深圳200028,深圳002600,上海603233,上海600369,深圳002373,深圳002340,上海600820,上海601068,深圳200869,深圳000869,上海600315,深圳002078,上海600317,上海600282,上海600845,上海900926,深圳002085,上海600901,上海600584,上海600021,上海601100,深圳300324,深圳000681,上海600572,上海601139,上海601179,深圳000623,上海600582,上海600739,上海600548,深圳002223,上海600376,深圳000581,深圳200581,深圳002382,上海601611,深圳000089,深圳300618,上海600959,深圳002670,上海600777,深圳002572,上海603883,上海603225,上海600707,上海601555,上海601966,深圳002129,深圳000729,上海600612,上海600056,上海900905,深圳000990,上海600258,深圳002625,上海603517,上海601127,深圳000998,深圳002127,深圳002092,上海600909,深圳002640,深圳002281,深圳200429,深圳000429,上海601005,深圳002268,上海600879,上海601326,深圳002797,上海600779,上海600598,深圳000960,深圳000066,上海600885,上海600681,上海601928,上海600008,上海600150,深圳002821,上海600079,上海600062,深圳002217,深圳000723,深圳002665,深圳002302,深圳000826,深圳002925,上海600126,上海600545,上海600167,深圳000060,上海601718,深圳002152,上海600803,深圳000564,深圳300009,深圳000987,上海900947,上海600320,上海600763,上海601019,上海600392,上海600884,上海600226,深圳000975,上海600567,上海600811,上海601168,深圳002500,上海600098,上海600507,深圳002867,深圳200488,深圳000488,上海603568,上海600521,上海600007,上海603077,上海600500,上海600827,上海900923,上海600823,深圳002385,深圳000401,上海603486,深圳300418,上海601099,深圳000717,上海600380,深圳000761,深圳200761,深圳002358,上海600643,上海600086,深圳000738,深圳300699,上海600273,上海600737,深圳000690,上海600835,上海900925,深圳002221,上海603712,深圳000997,上海600648,上海603650,上海900912,上海601000,深圳300168,上海600325,深圳002419,上海600536,深圳000040,深圳000937,深圳000688,深圳000559,上海600409,深圳002233,上海603501,上海600338,上海600373,深圳002074,深圳000062,深圳300001,深圳002128,深圳300616,深圳300558,上海600132,上海600348,深圳300176,深圳002690,深圳002668,深圳002701,深圳000560,上海600486,上海600895,深圳000503,深圳002815,上海600466,深圳002537,上海601128,上海600277,深圳002727,深圳000537,深圳002603,上海600740,深圳002589,深圳000686,上海600649,深圳002051,深圳002174,深圳300459,上海600873,深圳300207,深圳000750,深圳002203,深圳300197,深圳300027,深圳000636,上海600718,深圳000598,深圳300182,深圳300316,上海603025,上海600483,上海600039,上海601799,深圳000968,深圳002583,上海600307,上海600260,深圳002262,深圳300088,上海601801,上海603198,深圳002019,深圳002653,深圳200022,深圳000022,上海600863,上海600037,上海600717,深圳300294,深圳300180,深圳002212,上海600460,深圳002463,深圳000029,上海603338,深圳000887,深圳002138,深圳000710,深圳002368,深圳002387,深圳000839,深圳000156,深圳000988,深圳000878,上海600682,上海600917,深圳300166,深圳002341,深圳000902,上海600291,上海600060,上海600755,上海600267,上海601375,上海603707,上海603806,深圳000008,深圳300357,深圳002183,上海600179,深圳000918,深圳300188,上海601330,上海600667,上海600787,深圳002376,上海600859,深圳002424,深圳002244,深圳002901,上海601608,深圳002030,深圳002025,深圳002242,上海600266,上海601717,上海600639,上海900911,深圳002512,深圳002061,深圳002440,深圳300068,深圳300038,上海603355,上海600729,深圳000807,上海600435,上海600764,深圳000528,深圳300315,上海601689,上海600155,上海600839,上海600166,深圳300104,上海600771,深圳002151,上海600685,深圳300222,深圳000935,深圳002648,深圳300633,深圳300098,上海600804,深圳002911,深圳300474,深圳300476,深圳300271,深圳300285,深圳002191,深圳300634,深圳300323,上海603567,上海603708,上海600143,上海600881,深圳300014,上海600597,深圳300012,深圳000059,上海600120,深圳002258,深圳002595,深圳300376,深圳000088,深圳300482,上海600559,深圳002647,深圳300463,深圳200012,深圳000012,深圳300113,上海600125,深圳000582,上海601636,深圳000676,深圳000555,深圳002818,上海600138,上海600970,深圳000547,深圳000563,上海601069,深圳000735,上海600728,深圳000666,深圳002920,深圳000683,上海600633,深圳002080,深圳300026,深圳300451,深圳300170,上海600312,深圳300212,上海603337,上海601606,上海601258,上海600057,深圳000685,深圳300199,深圳002285,深圳002737,深圳300666,上海600420,上海603733,深圳002389,上海601016,深圳002309,深圳300073,上海600490,上海600869,上海600491,深圳002717,深圳002430,深圳002287,深圳002383,上海600908,上海600329,深圳300036,深圳000400,深圳002461,深圳300630,上海601952,上海600657,上海603013,深圳002004,深圳002511,上海600094,上海900940,深圳002617,深圳300058,深圳300244,上海600997,深圳000516,上海601011,上海600400,深圳300567,深圳300203,深圳002396,深圳300377,深圳300457,上海600093,深圳002557,深圳002359,上海600323,深圳300726,上海600395,深圳000034,深圳300496,深圳000921,深圳000042,深圳000989,深圳002839,深圳002414,上海600269,深圳000711,深圳002491,上海600635,上海603103,深圳000950,上海600664,深圳002157,深圳002280,深圳002444,上海600596,上海601163,深圳000800,上海600122,上海601918,深圳002912,深圳300365,上海603693,深圳002320,深圳002807,上海600711,上海600965,深圳002131,深圳000519,深圳000767,深圳002176,上海601811,深圳000031,深圳300373,上海600403,深圳002156,上海601107,上海603043,深圳002185,深圳002426,上海601369,上海600231,上海600252,上海601567,深圳002859,上海600563,上海600388,深圳000150,深圳000980,深圳000591,上海600180,深圳000718,深圳002047,深圳002047,上海900938,深圳000048,上海601200,深圳002672,上海603328,上海601666,深圳002597,上海603323,深圳000426,深圳000525,深圳300523,上海601619,深圳000831,上海603699,上海600939,上海600828,上海603596,深圳300339,深圳000650,上海600185,上海600418,深圳300740,上海601311,深圳000739,深圳002635,上海600874,上海600569,上海600981,深圳000009,上海603877,上海603096,深圳300237,深圳002611,深圳000078,深圳000620,上海603345,上海600619,上海900910,深圳300159,深圳002614,深圳002573,深圳000889,上海603680,深圳002267,深圳000848,深圳300274,深圳002747,深圳002042,上海600216,深圳300037,深圳002056,上海603766,上海600715,深圳200726,深圳000726,上海603039,深圳002503,上海603989,上海600580,深圳002016,深圳000662,深圳002434,上海600929,深圳300267,上海601101,上海601969,上海600141,深圳300595,深圳002429,上海600012,上海603587,深圳002517,上海900903,深圳002249,上海600017,上海600611,上海600562,深圳002273,上海600305,深圳000930,上海603882,深圳002681,深圳002485,上海601015,上海601001,深圳300257,深圳000933,上海600781,上海600748,深圳300495,深圳000501,深圳000712,深圳002028,上海600116,上海600175,上海603305,上海600123,深圳002002,上海600090,上海601588,深圳002542,深圳002643,上海603367,上海603113,深圳000970,上海600575,上海600033,上海601886,深圳002275,上海600064,深圳002390,上海603876,深圳000923,深圳002678,深圳000021,上海600702,上海600295,上海900936,深圳002168,深圳002677,上海603533,深圳002035,上海600525,上海601515,深圳002482,深圳002091,上海600429,深圳300367,深圳000766,深圳002266,深圳300115,深圳300010,深圳002155,深圳000600,上海600797,深圳000550,深圳200550,深圳200025,上海601113,深圳000025,上海600508,上海600246,深圳300226,深圳002626,上海603619,深圳002618,深圳000090,深圳300149,深圳300078,深圳002545,上海600694,深圳300602,上海603000,深圳002314,深圳000672,上海600020,上海600197,上海600621,上海600446,深圳300510,深圳000789,上海600337,深圳300458,上海600708,深圳000802,深圳002907,深圳300724,上海601339,深圳002099,深圳300429,上海600757,上海603605,深圳300300,上海601222,深圳002768,深圳000056,深圳000877,深圳200056,深圳000881,上海603444,深圳000158,上海600230,上海603105,上海603678,深圳002292,深圳002250,上海600428,深圳000951,上海600259,深圳000543,深圳300284,上海600477,上海603888,深圳002610,深圳002421,上海600850,上海601566,深圳000061,深圳000758,上海603718,上海600645,上海603377,上海600640,深圳000016,深圳002366,深圳200016,深圳002237,上海600862,深圳300577,上海603387,深圳002226,上海603368,深圳002370,上海603298,深圳000541,深圳002064,深圳200541,深圳002928,深圳002585,深圳000507,上海600529,深圳002293,上海600641,深圳300145,深圳000719,上海600058,上海601949,深圳002505,深圳000828,深圳000631,深圳002317,深圳002023,深圳300134,上海603730,深圳000967,上海600761,深圳002219,深圳002121,深圳002407,上海600864,深圳300348,上海600812,深圳002215,深圳000566,深圳000006,深圳300309,上海601519,深圳002930,深圳002303,深圳002416,深圳002210,深圳300055,深圳300232,深圳002020,上海600546,深圳300369,深圳002697,上海600789,深圳000517,上海600856,上海600006,深圳000697,深圳002254,上海600499,上海600783,上海601678,上海603421,深圳002375,深圳002709,深圳002596,深圳000065,深圳002251,上海600162,深圳002497,深圳300349,深圳200030,深圳000030,深圳002409,上海900942,上海600054,深圳002498,上海600195,深圳300107,上海900908,上海600618,深圳002449,上海600933,上海900901,上海600602,上海601858,深圳300002,深圳000038,深圳002488,深圳300527,深圳000818,深圳300398,深圳000979,上海600759,深圳002364,上海600550,深圳002683,深圳002656,上海600410,上海600158,深圳000597,上海603638,深圳002327,上海600996,深圳300326,深圳002543,深圳300685,上海603569,深圳300287,上海600335,上海600750,深圳002113,深圳002093,深圳002530,上海600936,深圳300456,深圳300355,深圳300504,上海600581,上海601900,深圳002531,深圳300297,上海600990,深圳002097,深圳300178,上海603393,上海601116,上海600687,深圳000810,上海601366,深圳002752,上海600577,上海600096,深圳000882,上海900917,上海600851,上海600565,深圳000546,深圳002705,上海600502,深圳002437,上海600242,深圳300725,深圳002123,深圳002048,深圳300085,上海600971,上海601558,上海601929,深圳002929,深圳002607,深圳002851,上海603609,上海600810,深圳002095,上海600217,深圳002204,深圳300298,上海603399,深圳002239,上海603898,深圳000552,深圳000926,上海601908,深圳300101,深圳002586,深圳002675,深圳300661,深圳300053,上海600129,上海600326,深圳002228,深圳002544,上海601058,上海603698,上海601965,上海600510,上海600897,上海600988,深圳002699,深圳300401,深圳000639,上海600770,上海600478,上海900907,上海600614,深圳002619,上海600316,深圳000035,上海600993,深圳002650,深圳000829,上海600073,深圳002707,上海600963,深圳002698,深圳300664,深圳002269,上海603556,上海600661,上海603357,深圳000727,深圳000900,深圳002913,上海600171,深圳002716,上海600604,上海900902,深圳300276,深圳300054,深圳002431,深圳002190,深圳002413,深圳002108,上海600456,深圳000917,上海600617,上海900913,上海600557,上海600169,深圳000976,深圳002124,上海600986,上海603429,深圳002685,上海603848,深圳300266,上海603826,深圳002118,上海600622,上海600481,深圳002798,深圳000733,上海600389,上海603711,深圳000799,上海600892,深圳000403,深圳000901,上海603980,深圳000861,深圳002126,深圳000498,深圳000910,深圳300064,上海600765,深圳002695,深圳002435,上海600182,深圳002662,上海600756,深圳000852,上海600458,深圳300477,深圳002003,上海603055,深圳300735,深圳002332,深圳000667,上海603660,深圳300131,深圳002344,深圳002509,上海600638,深圳000875,上海600059,深圳300233,深圳002145,上海600736,深圳000793,上海600978,上海600151,深圳300219,深圳002313,上海603588,深圳002489,深圳300737,深圳300108,深圳002442,上海600603,深圳300682,上海900952,上海600190,深圳002135,深圳002356,上海603027,深圳300423,上海600601,深圳300684,上海600206,深圳002792,深圳002564,深圳002326,深圳002726,深圳002279,上海603808,上海603128,深圳002741,深圳300571,深圳000587,深圳000534,深圳002436,深圳002369,上海603881,深圳300673,上海600330,深圳300506,上海600987,上海603676,深圳300559,上海603919,上海600184,深圳300191,深圳300342,深圳002478,深圳002402,上海603666,深圳002636,深圳000536,深圳002301,深圳300114,上海600072,深圳002621,深圳002502,深圳300185,深圳002832,上海601010,深圳002256,深圳300077,上海600278,上海600351,上海601777,上海600067,上海603579,上海600131,深圳000557,深圳300184,深圳002036,深圳002068,深圳002646,深圳300572,上海600108,深圳002307,深圳300183,上海600053,深圳300624,深圳002022,深圳002540,深圳300204,上海603869,深圳002143,深圳000928,上海600720,深圳002550,上海603318,深圳002343,上海600035,深圳300467,上海603359,上海603218,深圳000863,深圳200011,深圳000011,上海603603,上海603997,深圳001696,上海600503,深圳002427,深圳002276,上海600308,深圳300434,上海600658,上海600393,深圳000797,深圳300143,深圳000796,上海600693,上海603599,上海603508,上海601677,上海600841,上海900920,深圳300047,深圳300130,深圳000410,深圳300745,深圳300439,深圳000049,上海603728,上海603706,上海600422,上海600300,上海603008,上海600495,深圳000036";
    //获取返回json结果
    String  getReult(String url,String params) throws JSONException {
        HttpRequest httpRequest = new HttpRequest();
        String result = httpRequest.sendGet(url,params);
        return result;

    }
    //对返回结果进行处理 获取所有数据{"2018-01-01":"12.222"}
    public JSONObject getData(String res) throws JSONException {
        JSONArray json = new JSONArray(res);
        JSONObject object = json.getJSONObject(0).getJSONObject("data");

        JSONObject format=new JSONObject();
        Iterator iterator = object.keys();
        while(iterator.hasNext()){
            String key = (String) iterator.next();
            String value = object.getString(key);
            key = key.replace("_","-");
            key=key.substring(1,key.length());
            format.put(key,value);
        }
        return format;

    }
    //获取近几年波动率
    public ArrayList<Float> getNumYearsData(int num,JSONObject obj) throws JSONException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        Date now = new Date();
        c.setTime(now);
        c.add(Calendar.YEAR, -num);
        Date y = c.getTime();
        String year = format.format(y);
        //System.out.println("过去一年："+year);
        ArrayList<Float> fls = new ArrayList<Float>();
        Iterator iterator = obj.keys();
        while(iterator.hasNext()){
            String key = (String) iterator.next();
            String value = obj.getString(key);
            Float fl = Float.parseFloat(value);
            //System.out.println(key+":"+value);
            fls.add(fl);

        }

        return fls;

    }

    //获取平均数
    public float getAvergeNum(ArrayList<Float>  obj) throws JSONException {
        Float  sum  = obj.stream().reduce(Float.parseFloat("0"), (acc, element) -> acc + element);
        return sum/obj.size();
    }

    //获取方差
    public float getFangCha(ArrayList<Float> list,float avger){
        Float  sum  = list.stream().reduce(Float.parseFloat("0"), (acc, element) ->acc+(float)Math.pow((element/avger-1), 2));
        return  sum/list.size();
    }


    public float runStock(String urlStr) throws JSONException {

        String res = getReult(urlStr,params);
        JSONObject resJson = getData(res);
        ArrayList<Float> numYearsData=getNumYearsData(2,resJson);
        float averge = getAvergeNum(numYearsData);
        float fang = getFangCha(numYearsData,averge);
        return fang;

    }

    //批量获取方差
    public  HashMap<String,Float>  batchRun()  {
        LinkedHashMap<String,Float> result = new LinkedHashMap<String, Float>();
        String[] urls = stockNum.replace("上海","sh").replace("深圳","sz").split(",");
        model.setNumAll(urls.length);
        for (int i = 0; i <urls.length; i++) {
            final String code = urls[i];
            threadPoolExecutor.execute(()-> {
                try {
                    //System.out.println("多线程："+code);
                    Float fang=runStock("http://finance.sina.com.cn/realstock/company/"+code+"/qianfuquan.js");
                    model.setNum(model.getNum()+1);
                    result.put(code,fang);

                    System.out.println("多线程："+code+"："+model.getNum());
                }catch (JSONException e){
                    model.setNumAll(model.getNumAll()-1);
                    e.printStackTrace();
                }

            });

        }

        while (model.getNum()<model.getNumAll()){
            System.out.println("modelNum:"+model.getNum());
        };
        return result;

    }

    //获取波动率最小的500只股票
    public String  getMin500(HashMap<String,Float> result){
        List<String> result3 = new ArrayList<String>();
        List<Float> result4 = new ArrayList<Float>();
        for (String key : result.keySet()) {
            float fl = result.get(key);
            if(result4.size()==0){result4.add(fl);result3.add(key);continue;}
            for (int i = result4.size()-1; i>-1 ; i--) {
                if(result4.get(i)<fl){
                    result4.add(i+1,fl);
                    result3.add(i+1,key);
                    break;
                }else if(i==0){
                    result4.add(0,fl);
                    result3.add(0,key);

                }

            }
        }
        String finalRes="";
        for (int i = 0; i <min ; i++) {
            System.out.println(result3.get(i).replace("sh","").replace("sz","")+":"+result4.get(i));
            finalRes+=(","+result3.get(i).replace("sh","").replace("sz",""));
        }
        System.out.println(finalRes);
        return finalRes;

    }


//    public static void main(String[] args) throws JSONException {
//        StockUtils main = new StockUtils();
//        HashMap<String,Float> res= main.batchRun();
//        main.getMin500(res);
//
//    }
}